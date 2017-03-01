package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@JsonIgnoreProperties
public class DarkSkyWeatherInfo
{
    @JsonProperty(value = "timezone")
    String timezone;

    @JsonProperty(value = "currently")
    Currently currently;

    @JsonProperty(value = "daily")
    Daily daily;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }
}
