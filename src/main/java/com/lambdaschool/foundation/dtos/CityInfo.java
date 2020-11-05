package com.lambdaschool.foundation.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public class CityInfo{
    @JsonValue
    private int cityid;
    @JsonValue
    private String citynamestate;

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCitynamestate() {
        return citynamestate;
    }

    public void setCitynamestate(String citynamestate) {
        this.citynamestate = citynamestate;
    }
}
