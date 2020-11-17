package com.lambdaschool.foundation.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City extends Auditable
{

    /**
     * Generate City id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityid;

    /**
     * The City name (String)
     */
    @NotNull
    private String citynamestate;

    /**
     * The two letter state abbreviation
     */
    private String statecode;

    /**
     * City's Timezone
     */
    private String timezone;

    /**
     * City's latitude
     */
    private Double latitude;

    /**
     * City's longitude
     */
    private Double logitude;

    /**
     * City's FPIS
     */
    private String fpis;

    /**
     * City's GNIS
     */
    private String gnis;

    /**
     * City's wiki image url
     */
    @Column(columnDefinition = "TEXT")
    private String wikiimgurl;

    /**
     * City's website
     */
    private String website;

    /**
     * City's average population
     */
    private Double population;

    /**
     * City's population density per square mile
     */
    private Double densitymisq;

    /**
     * City's population density per square kilometer
     */
    private Double densitykmsq;

    /**
     * City's average age
     */
    private Double averageage;

    /**
     * City's average household income
     */
    private Double householdincome;

    /**
     * City's average individual income
     */
    private Double individualincome;

    /**
     * City's average housing cost
     */
    private Double averagehouse;

    /**
     * City's average rent cost
     */
    private Double rent;

    /**
     * City's average cost of living index
     */
    private Double costoflivingindex;

    /**
     * City's current ACA status
     */
    private String acastatus;

    /**
     * City's average temp
     * calculated from the historical weather data
     */
    private Double averagetemp;

    /**
     * City's average percipitation
     * calculated from historical weather data
     */
    private Double averageperc;

    /**
     * City's average new covid-19 cases
     * calculated from the historical covid data
     */
    private Double avgnewcovidcases;

    /**
     * List of City's zipcodes
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Zipcode> zipcodes = new ArrayList<>();

    /**
     * List of City's counties
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<County> counties = new ArrayList<>();

    /**
     * List of historical population data
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<PopulationHist> populationhist = new ArrayList<>();

    /**
     * List of historical income data
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<HistoricalIncome> historicalincome = new ArrayList<>();

    /**
     * List of historical housing cost
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<HistoricalHousing> historicalaveragehouse = new ArrayList<>();

    /**
     * List of reported Covid-19 cases
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<HistoricalCovid> covid = new ArrayList<>();

    /**
     * List of historical weather data
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<HistoricalWeather> historicalweather = new ArrayList<>();

    /**
     * List of User's who have favorited the city
     */
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<UserCities> users = new HashSet<>();

    /**
     * The Default constructor needed by JPA
     */
    public City()
    {
    }

    /**
     * The constructor with the non-nullable fields
     */
    public City(
        @NotNull String citynamestate)
    {
        this.citynamestate = citynamestate;
    }

    /**
     * Getters and setters for the City's fields
     *
     **************************************************************************/



    public long getCityid()
    {
        return cityid;
    }


    public void setCityid(long cityid)
    {
        this.cityid = cityid;
    }

    public String getCitynamestate()
    {
        return citynamestate;
    }

    public void setCitynamestate(String citynamestate)
    {
        this.citynamestate = citynamestate;
    }

    public String getStatecode()
    {
        return statecode;
    }

    public void setStatecode(String statecode)
    {
        this.statecode = statecode;
    }

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLogitude()
    {
        return logitude;
    }

    public void setLogitude(Double logitude)
    {
        this.logitude = logitude;
    }

    public String getFpis()
    {
        return fpis;
    }

    public void setFpis(String fpis)
    {
        this.fpis = fpis;
    }

    public String getGnis()
    {
        return gnis;
    }

    public void setGnis(String gnis)
    {
        this.gnis = gnis;
    }

    public String getWikiimgurl()
    {
        return wikiimgurl;
    }

    public void setWikiimgurl(String wikiimgurl)
    {
        this.wikiimgurl = wikiimgurl;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Double getPopulation()
    {
        return population;
    }

    public void setPopulation(Double population)
    {
        this.population = population;
    }

    public Double getDensitymisq()
    {
        return densitymisq;
    }

    public void setDensitymisq(Double densitymisq)
    {
        this.densitymisq = densitymisq;
    }

    public Double getDensitykmsq()
    {
        return densitykmsq;
    }

    public void setDensitykmsq(Double densitykmsq)
    {
        this.densitykmsq = densitykmsq;
    }

    public Double getAverageage()
    {
        return averageage;
    }

    public void setAverageage(Double averageage)
    {
        this.averageage = averageage;
    }

    public Double getHouseholdincome()
    {
        return householdincome;
    }

    public void setHouseholdincome(Double householdincome)
    {
        this.householdincome = householdincome;
    }

    public Double getIndividualincome()
    {
        return individualincome;
    }

    public void setIndividualincome(Double individualincome)
    {
        this.individualincome = individualincome;
    }

    public Double getAveragehouse()
    {
        return averagehouse;
    }

    public void setAveragehouse(Double averagehouse)
    {
        this.averagehouse = averagehouse;
    }

    public Double getRent()
    {
        return rent;
    }

    public void setRent(Double rent)
    {
        this.rent = rent;
    }

    public Double getCostoflivingindex()
    {
        return costoflivingindex;
    }

    public void setCostoflivingindex(Double costoflivingindex)
    {
        this.costoflivingindex = costoflivingindex;
    }

    public String getAcastatus()
    {
        return acastatus;
    }

    public void setAcastatus(String acastatus)
    {
        this.acastatus = acastatus;
    }

    public List<Zipcode> getZipcodes()
    {
        return zipcodes;
    }

    public void setZipcodes(List<Zipcode> zipcodes)
    {
        this.zipcodes = zipcodes;
    }

    public List<County> getCounties()
    {
        return counties;
    }

    public void setCounties(List<County> counties)
    {
        this.counties = counties;
    }

    public List<PopulationHist> getPopulationhist()
    {
        return populationhist;
    }

    public void setPopulationhist(List<PopulationHist> populationhist)
    {
        this.populationhist = populationhist;
    }

    public List<HistoricalIncome> getHistoricalincome()
    {
        return historicalincome;
    }

    public void setHistoricalincome(List<HistoricalIncome> historicalincome)
    {
        this.historicalincome = historicalincome;
    }

    public List<HistoricalHousing> getHistoricalaveragehouse()
    {
        return historicalaveragehouse;
    }

    public void setHistoricalaveragehouse(List<HistoricalHousing> historicalaveragehouse)
    {
        this.historicalaveragehouse = historicalaveragehouse;
    }

    public List<HistoricalCovid> getCovid()
    {
        return covid;
    }

    public void setCovid(List<HistoricalCovid> covid)
    {
        this.covid = covid;
    }

    public List<HistoricalWeather> getHistoricalweather()
    {
        return historicalweather;
    }

    public void setHistoricalweather(List<HistoricalWeather> historicalweather)
    {
        this.historicalweather = historicalweather;
    }

    public Set<UserCities> getUsers()
    {
        return users;
    }

    public void setUsers(Set<UserCities> users)
    {
        this.users = users;
    }

    public Double getAveragetemp()
    {
        return averagetemp;
    }

    public void setAveragetemp(Double averagetemp)
    {
        this.averagetemp = averagetemp;
    }

    public Double getAverageperc()
    {
        return averageperc;
    }

    public void setAverageperc(Double averageperc)
    {
        this.averageperc = averageperc;
    }

    public Double getAvgnewcovidcases()
    {
        return avgnewcovidcases;
    }

    public void setAvgnewcovidcases(Double avgnewcovidcases)
    {
        this.avgnewcovidcases = avgnewcovidcases;
    }

    /**
     * Override default toString()
     * @return string of City object
     */
    @Override
    public String toString()
    {
        return "City{" +
            "cityid=" + cityid +
            ", citynamestate='" + citynamestate + '\'' +
            ", statecode='" + statecode + '\'' +
            ", timezone='" + timezone + '\'' +
            ", latitude=" + latitude +
            ", logitude=" + logitude +
            ", fpis='" + fpis + '\'' +
            ", gnis='" + gnis + '\'' +
            ", wikiimgurl='" + wikiimgurl + '\'' +
            ", website='" + website + '\'' +
            ", population=" + population +
            ", densitymisq=" + densitymisq +
            ", densitykmsq=" + densitykmsq +
            ", averageage=" + averageage +
            ", householdincome=" + householdincome +
            ", individualincome=" + individualincome +
            ", averagehouse=" + averagehouse +
            ", rent=" + rent +
            ", costoflivingindex=" + costoflivingindex +
            ", acastatus='" + acastatus + '\'' +
            ", averagetemp=" + averagetemp +
            ", averageperc=" + averageperc +
            ", avgnewcovidcases=" + avgnewcovidcases +
            ", zipcodes=" + zipcodes +
            ", counties=" + counties +
            ", populationhist=" + populationhist +
            ", historicalincome=" + historicalincome +
            ", historicalaveragehouse=" + historicalaveragehouse +
            ", covid=" + covid +
            ", historicalweather=" + historicalweather +
            ", users=" + users +
            '}';
    }
}
