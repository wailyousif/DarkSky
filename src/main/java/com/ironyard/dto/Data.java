package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by wailm.yousif on 3/1/17.
 */

@JsonIgnoreProperties
public class Data
{
    @JsonProperty(value = "time")
    private long time;

    @JsonProperty(value = "summary")
    private String summary;

    @JsonProperty(value = "icon")
    private String icon;

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}