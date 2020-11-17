package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "historicalhousing")
public class HistoricalHousing extends Auditable
{
    /**
     * Model for City's historical housing cost data
     */

    /**
     * Data entry ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long houseid;

    /**
     * Year of entry
     */
    @NotNull
    private int year;

    /**
     * Month of entry
     */
    @NotNull
    private int month;

    /**
     * Avereage housing cost of recorded data
     */
    @NotNull
    private int housingcost;

    /**
     * City entry belongs to
     */
    @ManyToOne()
    @JoinColumn(name = "cityid")
    @NotNull
    @JsonIgnore
    private City city;

    /**
     * Default constructor
     */
    public HistoricalHousing()
    {
    }

    /**
     * Main constructor
     * @param year Year of entry
     * @param month Month of entry
     * @param housingcost Cost at date of entry
     * @param city City entry belongs to
     */
    public HistoricalHousing(
        @NotNull int year,
        @NotNull int month,
        @NotNull int housingcost,
        @NotNull City city)
    {
        this.year = year;
        this.month = month;
        this.housingcost = housingcost;
        this.city = city;
    }

    /**
     * Getters and setters for HistoricalHousing's fields
     *
     ********************************************************************************/
    public long getHouseid()
    {
        return houseid;
    }

    public void setHouseid(long houseid)
    {
        this.houseid = houseid;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getHousingcost()
    {
        return housingcost;
    }

    public void setHousingcost(int housingcost)
    {
        this.housingcost = housingcost;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    /**
     * Override default toString()
     * @return String of HistoricalHousing object
     */
    @Override
    public String toString()
    {
        return "HistoricalHousing{" +
            "year=" + year +
            ", month=" + month +
            ", housingcost=" + housingcost +
            '}';
    }
}
