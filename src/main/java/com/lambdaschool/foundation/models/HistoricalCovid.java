package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "historicalcovid")
public class HistoricalCovid extends Auditable
{
    /**
     * Model for City's historical Covid-19 data
     */

    /**
     * Covid entry ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long covidid;

    /**
     * Year of entry's data
     */
    @NotNull
    private int year;

    /**
     * Month of entry's data
     */
    @NotNull
    private int month;

    /**
     * Day of entry's data
     */
    @NotNull
    private int day;

    /**
     * Cases recorded on entry's date
     */
    @NotNull
    private int cases;

    /**
     * City entry belongs to
     */
    @ManyToOne
    @JoinColumn(name = "cityid")
    @NotNull
    @JsonIgnore
    private City city;

    /**
     * Default constructor
     */
    public HistoricalCovid()
    {
    }

    /**
     * Main constructor
     * @param year Year of entry
     * @param month Month of entry
     * @param day Day of entry
     * @param cases Cases recorded date of entry
     * @param city City entry belongs to
     */
    public HistoricalCovid(
        @NotNull int year,
        @NotNull int month,
        @NotNull int day,
        @NotNull int cases,
        @NotNull City city)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.cases = cases;
        this.city = city;
    }

    /**
     * Getters and Setters for HistoricalCovid's fields
     *
     **************************************************************************************/

    public long getCovidid()
    {
        return covidid;
    }

    public void setCovidid(long covidid)
    {
        this.covidid = covidid;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getCases()
    {
        return cases;
    }

    public void setCases(int cases)
    {
        this.cases = cases;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    /**
     * Override default toString()
     * @return String of HistoricalCovid object
     */
    @Override
    public String toString()
    {
        return "HistoricalCovid{" +
            "year=" + year +
            ", month=" + month +
            ", day=" + day +
            ", cases=" + cases +
            '}';
    }
}
