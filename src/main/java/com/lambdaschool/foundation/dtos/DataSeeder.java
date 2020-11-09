package com.lambdaschool.foundation.dtos;

import com.lambdaschool.foundation.models.*;

import java.util.HashSet;
import java.util.Set;

public class DataSeeder {
    private Long cityid;
    private String citynamestate;
    private String statecode;
    private String timezone;
    private Double logitude;
    private Double latitude;
    private String fpis;
    private String gnis;
    private String wikiimgurl;
    private String website;
    private Double population;
    private Double densitymisq;
    private Double densitykmsq;
    private Double averageage;
    private Double householdincome;
    private Double individualincome;
    private Double averagehouse;
    private Double rent;
    private Double costoflivingindex;
    private String acastatus;
    private Double averagetemp;
    private Double averageperc;
    private Double avgnewcovidcases;
    private Set<Zipcode> zipcodes = new HashSet<>();
    private Set<County> counties = new HashSet<>();
    private Set<PopulationHist> populationhist = new HashSet<>();
    private Set<HistoricalIncome> historicalincome = new HashSet<>();
    private Set<HistoricalHousing> historicalaveragehouse = new HashSet<>();
    private Set<HistoricalCovid> covid = new HashSet<>();
    private Set<HistoricalWeather> historicalweather = new HashSet<>();

    public DataSeeder() {
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getCitynamestate() {
        return citynamestate;
    }

    public void setCitynamestate(String citynamestate) {
        this.citynamestate = citynamestate;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Double getLogitude() {
        return logitude;
    }

    public void setLogitude(Double logitude) {
        this.logitude = logitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getFpis() {
        return fpis;
    }

    public void setFpis(String fpis) {
        this.fpis = fpis;
    }

    public Double getHouseholdincome() {
        return householdincome;
    }

    public void setHouseholdincome(Double householdincome) {
        this.householdincome = householdincome;
    }

    public Double getIndividualincome() {
        return individualincome;
    }

    public void setIndividualincome(Double individualincome) {
        this.individualincome = individualincome;
    }

    public Double getAveragehouse() {
        return averagehouse;
    }

    public void setAveragehouse(Double averagehouse) {
        this.averagehouse = averagehouse;
    }

    public String getGnis() {
        return gnis;
    }

    public void setGnis(String gnis) {
        this.gnis = gnis;
    }

    public String getWikiimgurl() {
        return wikiimgurl;
    }

    public void setWikiimgurl(String wikiimgurl) {
        this.wikiimgurl = wikiimgurl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getDensitymisq() {
        return densitymisq;
    }

    public void setDensitymisq(Double densitymisq) {
        this.densitymisq = densitymisq;
    }

    public Double getDensitykmsq() {
        return densitykmsq;
    }

    public void setDensitykmsq(Double densitykmsq) {
        this.densitykmsq = densitykmsq;
    }

    public Double getAverageage() {
        return averageage;
    }

    public void setAverageage(Double averageage) {
        this.averageage = averageage;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getCostoflivingindex() {
        return costoflivingindex;
    }

    public void setCostoflivingindex(Double costoflivingindex) {
        this.costoflivingindex = costoflivingindex;
    }

    public String getAcastatus() {
        return acastatus;
    }

    public void setAcastatus(String acastatus) {
        this.acastatus = acastatus;
    }

    public Double getAveragetemp() {
        return averagetemp;
    }

    public void setAveragetemp(Double averagetemp) {
        this.averagetemp = averagetemp;
    }

    public Double getAverageperc() {
        return averageperc;
    }

    public void setAverageperc(Double averageperc) {
        this.averageperc = averageperc;
    }

    public Double getAvgnewcovidcases() {
        return avgnewcovidcases;
    }

    public void setAvgnewcovidcases(Double avgnewcovidcases) {
        this.avgnewcovidcases = avgnewcovidcases;
    }

    public Set<Zipcode> getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(Set<Zipcode> zipcodes) {
        this.zipcodes = zipcodes;
    }

    public Set<County> getCounties() {
        return counties;
    }

    public void setCounties(Set<County> counties) {
        this.counties = counties;
    }

    public Set<PopulationHist> getPopulationhist() {
        return populationhist;
    }

    public void setPopulationhist(Set<PopulationHist> populationhist) {
        this.populationhist = populationhist;
    }

    public Set<HistoricalIncome> getHistoricalincome() {
        return historicalincome;
    }

    public void setHistoricalincome(Set<HistoricalIncome> historicalincome) {
        this.historicalincome = historicalincome;
    }

    public Set<HistoricalHousing> getHistoricalaveragehouse() {
        return historicalaveragehouse;
    }

    public void setHistoricalaveragehouse(Set<HistoricalHousing> historicalaveragehouse) {
        this.historicalaveragehouse = historicalaveragehouse;
    }

    public Set<HistoricalCovid> getCovid() {
        return covid;
    }

    public void setCovid(Set<HistoricalCovid> covid) {
        this.covid = covid;
    }

    public Set<HistoricalWeather> getHistoricalweather() {
        return historicalweather;
    }

    public void setHistoricalweather(Set<HistoricalWeather> historicalweather) {
        this.historicalweather = historicalweather;
    }
}
