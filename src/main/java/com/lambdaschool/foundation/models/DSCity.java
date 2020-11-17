package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DSCity {

    /**
     * Model for data coming in from DS API
     * Needed to decode the JSON String before City is
     * saved to DB. This does not become a table.
     */

    /**
     * City's name
     */
    private String city;

    /**
     * City's state
     */
    private String statename;

    /**
     * City's two letter state abbreviation
     */
    private String abbrev;

    /**
     * City's zipcodes
     */
    private String ziplist;

    /**
     * City's timezone
     */
    private String timezone;

    /**
     * City's counties
     */
    private String counties;

    /**
     * City's latitude
     */
    private Double latitude;

    /**
     * City's longitude
     */
    private Double longitude;

    /**
     * City's FIPS
     */
    @JsonProperty("FIPS")
    private String FIPS;

    /**
     * City's GNIS
     */
    @JsonProperty("GNIS")
    private String GNIS;

    /**
     * City's Wikipedia image url
     */
    private String wiki_img_url;

    /**
     * City's website
     */
    private String website;

    /**
     * City's population
     */
    private Double pop;

    /**
     * City's density per square mile
     */
    private Double density_mi_sq;

    /**
     * City's density per square kilometer
     */
    private Double density_km_sq;

    /**
     * City's historical average population
     */
    @JsonProperty("pop_hist")
    private DSHistoricalPop pop_hist;

    /**
     * City's average age
     */
    private Double age;

    /**
     * City's average household income
     */
    private Double household;

    /**
     * City's average individual income
     */
    private Double individual;

    /**
     * City's historical average income
     */
    private DSHistoricalIncome income_hist;

    /**
     * City's average house cost
     */
    private Double house;

    /**
     * City's historical average home cost
     */
    private DSHistoricalHousing home_hist;

    /**
     * City's average rent
     */
    private Double rent;

    /**
     * City's cost of living index
     */
    @JsonProperty("COLI")
    private Double COLI;

    /**
     * City's ACA status
     */
    @JsonProperty("ACA_status")
    private String ACA_status;

    /**
     * City's historical weather
     */
//    @JsonProperty("weather_hist")
    private DSHistoricalWeather weather_hist;

    /**
     * City's Covid-19 cases
     */
    private DSHistoricalCovid jhcovid;

    /**
     * Default constructor
     */
    public DSCity()
    {
    }

    /**
     * Getters and setters for DSCity's fields
     *
     **********************************************************************************/


    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStatename()
    {
        return statename;
    }

    public void setStatename(String statename)
    {
        this.statename = statename;
    }

    public String getAbbrev()
    {
        return abbrev;
    }

    public void setAbbrev(String abbrev)
    {
        this.abbrev = abbrev;
    }

    public String getZiplist()
    {
        return ziplist;
    }

    public void setZiplist(String ziplist)
    {
        this.ziplist = ziplist;
    }

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }

    public String getCounties()
    {
        return counties;
    }

    public void setCounties(String counties)
    {
        this.counties = counties;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public String getFIPS()
    {
        return FIPS;
    }

    public void setFIPS(String FIPS)
    {
        this.FIPS = FIPS;
    }

    public String getGNIS()
    {
        return GNIS;
    }

    public void setGNIS(String GNIS)
    {
        this.GNIS = GNIS;
    }

    public String getWiki_img_url()
    {
        return wiki_img_url;
    }

    public void setWiki_img_url(String wiki_img_url)
    {
        this.wiki_img_url = wiki_img_url;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Double getPop()
    {
        return pop;
    }

    public void setPop(Double pop)
    {
        this.pop = pop;
    }

    public Double getDensity_mi_sq()
    {
        return density_mi_sq;
    }

    public void setDensity_mi_sq(Double density_mi_sq)
    {
        this.density_mi_sq = density_mi_sq;
    }

    public Double getDensity_km_sq()
    {
        return density_km_sq;
    }

    public void setDensity_km_sq(Double density_km_sq)
    {
        this.density_km_sq = density_km_sq;
    }

    public DSHistoricalPop getPop_hist()
    {
        return pop_hist;
    }

    public void setPop_hist(DSHistoricalPop pop_hist)
    {
        this.pop_hist = pop_hist;
    }

    public Double getAge()
    {
        return age;
    }

    public void setAge(Double age)
    {
        this.age = age;
    }

    public Double getHousehold()
    {
        return household;
    }

    public void setHousehold(Double household)
    {
        this.household = household;
    }

    public Double getIndividual()
    {
        return individual;
    }

    public void setIndividual(Double individual)
    {
        this.individual = individual;
    }

    public DSHistoricalIncome getIncome_hist()
    {
        return income_hist;
    }

    public void setIncome_hist(DSHistoricalIncome income_hist)
    {
        this.income_hist = income_hist;
    }

    public Double getHouse()
    {
        return house;
    }

    public void setHouse(Double house)
    {
        this.house = house;
    }

    public DSHistoricalHousing getHome_hist()
    {
        return home_hist;
    }

    public void setHome_hist(DSHistoricalHousing home_hist)
    {
        this.home_hist = home_hist;
    }

    public Double getRent()
    {
        return rent;
    }

    public void setRent(Double rent)
    {
        this.rent = rent;
    }

    public Double getCOLI()
    {
        return COLI;
    }

    public void setCOLI(Double COLI)
    {
        this.COLI = COLI;
    }

    public String getACA_status()
    {
        return ACA_status;
    }

    public void setACA_status(String ACA_status)
    {
        this.ACA_status = ACA_status;
    }

    public DSHistoricalWeather getWeather_hist()
    {
        return weather_hist;
    }

    public void setWeather_hist(DSHistoricalWeather weather_hist)
    {
        this.weather_hist = weather_hist;
    }

    public DSHistoricalCovid getJhcovid()
    {
        return jhcovid;
    }

    public void setJhcovid(DSHistoricalCovid jhcovid)
    {
        this.jhcovid = jhcovid;
    }

    /**
     * Override default toString()
     * @return String of DSCity object
     */
    @Override
    public String toString()
    {
        return "DSCity{" +
            "city='" + city + '\'' +
            ", statename='" + statename + '\'' +
            ", abbrev='" + abbrev + '\'' +
            ", ziplist='" + ziplist + '\'' +
            ", timezone='" + timezone + '\'' +
            ", counties='" + counties + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", FIPS='" + FIPS + '\'' +
            ", GNIS='" + GNIS + '\'' +
            ", wiki_img_url='" + wiki_img_url + '\'' +
            ", website='" + website + '\'' +
            ", pop=" + pop +
            ", density_mi_sq=" + density_mi_sq +
            ", density_km_sq=" + density_km_sq +
            ", pop_hist='" + pop_hist + '\'' +
            ", age=" + age +
            ", household=" + household +
            ", individual=" + individual +
            ", income_hist='" + income_hist + '\'' +
            ", house=" + house +
            ", home_hist='" + home_hist + '\'' +
            ", rent=" + rent +
            ", COLI=" + COLI +
            ", ACA_status='" + ACA_status + '\'' +
            ", weather_hist='" + weather_hist + '\'' +
            '}';
    }
}
