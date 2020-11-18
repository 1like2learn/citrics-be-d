package com.lambdaschool.foundation.dtos;

import com.fasterxml.jackson.annotation.JsonValue;

public class CityInfo
{
    @JsonValue
    private long cityid;
    @JsonValue
    private String citynamestate;

    public CityInfo(int cityid, String citynamestate)
    {
        this.cityid = cityid;
        this.citynamestate = citynamestate;
    }

    public CityInfo() {
    }

    public long getCityid() {
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
