package com.ironyard.api;

import com.ironyard.dto.DarkSkyWeatherInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wailm.yousif on 2/28/17.
 */


public class ApiHelper
{
    private static final String KEY = "10c23bb63ff974a0ca00cf3db995e9f2";

    private RestTemplate restTemplate;

    public ApiHelper()
    {
        restTemplate = new RestTemplate();
    }

    private HttpEntity getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity headersEntity = new HttpEntity(headers);
        return headersEntity;
    }

    public DarkSkyWeatherInfo getWeatherInfo(String latLon)
    {
        String url = "https://api.darksky.net/forecast/" + KEY + "/" + latLon;
        System.out.println("dark-sky invoked url:" + url);
        return (DarkSkyWeatherInfo) (restTemplate.exchange(url, HttpMethod.GET, getHeaders(), DarkSkyWeatherInfo.class)).getBody();
    }

}
