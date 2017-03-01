package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@JsonIgnoreProperties
public class Currently
{
    @JsonProperty(value = "time")
    private Long time;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "temperature")
    private Double temperature;

    @JsonProperty(value = "humidity")
    private Double humidity;

    @JsonProperty(value = "windSpeed")
    private Double windSpeed;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
