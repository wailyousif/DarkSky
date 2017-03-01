package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by wailm.yousif on 2/28/17.
 */
@Entity
public class Hist
{
    @Id
    @GeneratedValue
    private long id;

    private double lat;
    private double lon;
    private String timeZone;
    private String weatherSummary;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private Date timeStamp;

    @ManyToOne
    private AppUser appUser;

    public Hist() { }

    public Hist(double lat, double lon, String timeZone, String weatherSummary,
                double temperature, double humidity, double windSpeed, Date timeStamp,
                AppUser appUser)
    {
        this.lat = lat;
        this.lon = lon;
        this.timeZone = timeZone;
        this.weatherSummary = weatherSummary;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.timeStamp = timeStamp;
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getWeatherSummary() {
        return weatherSummary;
    }

    public void setWeatherSummary(String weatherSummary) {
        this.weatherSummary = weatherSummary;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
