package com.lambdaschool.foundation.dtos;

public class CityUpdater {
    private String wikiimgurl;
    private long cityid;

    public CityUpdater(String wikiimgurl, long cityid) {
        this.wikiimgurl = wikiimgurl;
        this.cityid = cityid;
    }

    public CityUpdater() {
    }

    public String getWikiimgurl() {
        return wikiimgurl;
    }

    public void setWikiimgurl(String wikiimgurl) {
        this.wikiimgurl = wikiimgurl;
    }

    public long getCityid() {
        return cityid;
    }

    public void setCityid(long cityid) {
        this.cityid = cityid;
    }
}
