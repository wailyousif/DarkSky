package com.ironyard.controller.mvc;

import com.ironyard.api.ApiHelper;
import com.ironyard.data.AppUser;
import com.ironyard.data.Hist;
import com.ironyard.dto.DarkSkyWeatherInfo;
import com.ironyard.repo.HistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@Controller
@RequestMapping(path = "/mvc/weather")
public class MvcWeatherController
{
    private static final String emptyString = "";

    @Autowired
    private HistRepo histRepo;

    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String show(HttpServletRequest request, Model model,
                       @RequestParam(value="lat", required = false) String lat,
                       @RequestParam(value = "lon", required = false) String lon)
    {
        String destinationView = "/secure/weather";

        model.addAttribute("getCurrentLoc", 0);

        if (lat == null && lon == null)
        {
            model.addAttribute("getCurrentLoc", 1);
            return destinationView;
        }

        if (lat.equals(emptyString))
            lat = "0.0";
        model.addAttribute("selectedLat", lat);

        if (lon.equals(emptyString))
            lon = "0.0";
        model.addAttribute("selectedLon", lon);

        //String latLon = lat.toString() + "," + lon.toString();
        String latLon = lat + "," + lon;
        DarkSkyWeatherInfo darkSkyWeatherInfo = (new ApiHelper()).getWeatherInfo(latLon);

        String timeZone = darkSkyWeatherInfo.getTimezone();
        String weatherSummary = darkSkyWeatherInfo.getCurrently().getSummary();
        double temperature = darkSkyWeatherInfo.getCurrently().getTemperature();
        double humidity = darkSkyWeatherInfo.getCurrently().getHumidity();
        double windSpeed = darkSkyWeatherInfo.getCurrently().getWindSpeed();

        model.addAttribute("timezone", timeZone);
        model.addAttribute("time", ConvertEpochToDateString(darkSkyWeatherInfo.getCurrently().getTime()));
        model.addAttribute("summary", weatherSummary);
        model.addAttribute("temperature", temperature);
        model.addAttribute("humidity", humidity);
        model.addAttribute("windSpeed", windSpeed);


        AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
        if (appUser != null)
        {
            Hist hist = new Hist(Double.parseDouble(lat), Double.parseDouble(lon), timeZone,
                    weatherSummary, temperature, humidity, windSpeed, (new Date()), appUser);
            histRepo.save(hist);
        }

        model.addAttribute("dataRead", "T");

        String forecasts = "<script src=\"/secure/skycons.js\"></script>";
        for (int i=0; i < 5; i++)
        {
            forecasts = forecasts + "<div class=\"col-sm-2\" id=\"day" + String.valueOf(i) + "\">";
            forecasts = forecasts + "<div class=\"day\">" + ConvertToWeekDay(darkSkyWeatherInfo.getDaily().getData().get(i).getTime()) + "</div><br />";
            //forecasts = forecasts + "<div class=\"skycon\">" + darkSkyWeatherInfo.getDaily().getData().get(i).getIcon() + "</div>";

            //forecasts = forecasts + "<canvas id=\"icon" + String.valueOf(i) + "\" width=\"128\" height=\"128\"></canvas>";

            forecasts = forecasts + "<div class=\"skycon\"> <canvas id=\"icon" + String.valueOf(i) + "\" width=\"128\" height=\"128\">" +
                    "</canvas></div>" +
                    "<script>" + buildJSCode(i, darkSkyWeatherInfo.getDaily().getData().get(i).getIcon()) + "</script>";

            forecasts = forecasts + "<div class=\"summary\">" + darkSkyWeatherInfo.getDaily().getData().get(i).getSummary() + "</div>";
            forecasts = forecasts + "</div>";
        }
        model.addAttribute("forecasts", forecasts);

        return destinationView;
    }

    private String buildJSCode(Integer i, String icon)
    {
        icon = (icon.replace("-", "_")).toUpperCase();

        String jsCode = "var skycons = new Skycons({\"color\": \"rgb(200, 223, 245)\"});";
        jsCode = jsCode + "skycons.add(\"icon" + i.toString() + "\", Skycons." + icon + ");";
        jsCode = jsCode + "skycons.play();";

        return jsCode;
    }


    private String ConvertEpochToDateString(Long epochTime)
    {
        Date currentTime = new Date(epochTime * 1000);
        return currentTime.toString();
    }

    private String ConvertToWeekDay(Long epochTime)
    {
        Date currentTime = new Date(epochTime * 1000);
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        String weekDay = dateFormat.format(currentTime);
        return weekDay;
    }
}
