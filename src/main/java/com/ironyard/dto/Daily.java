package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@JsonIgnoreProperties
public class Daily
{
    @JsonProperty(value = "data")
    List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
