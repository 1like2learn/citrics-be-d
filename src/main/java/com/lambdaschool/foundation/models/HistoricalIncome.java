package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "historicalincome")
public class HistoricalIncome extends Auditable
{
    /**
     * Model for City's historical income data
     */

    /**
     * Income ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long incid;

    /**
     * Year of entry
     */
    @NotNull
    private int year;

    /**
     * City's average individual income
     */
    @NotNull
    private int individualincome;

    /**
     * City's average household income
     */
    @NotNull
    private int householdincome;

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
    public HistoricalIncome()
    {
    }

    /**
     * Main constructor
     * @param year Year of entry
     * @param individualincome Average individual income
     * @param householdincome Average household income
     * @param city City entry belongs to
     */
    public HistoricalIncome(
        @NotNull int year,
        @NotNull int individualincome,
        @NotNull int householdincome,
        @NotNull City city)
    {
        this.year = year;
        this.individualincome = individualincome;
        this.householdincome = householdincome;
        this.city = city;
    }

    /**
     * Getters and setters for HistoricalIncome's fields
     *
     ****************************************************************************************/
    public long getIncid()
    {
        return incid;
    }

    public void setIncid(long incid)
    {
        this.incid = incid;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getIndividualincome()
    {
        return individualincome;
    }

    public void setIndividualincome(int income)
    {
        this.individualincome = income;
    }

    public int getHouseholdincome()
    {
        return householdincome;
    }

    public void setHouseholdincome(int householdincome)
    {
        this.householdincome = householdincome;
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
     * @return String of HistoricalIncome object
     */
    @Override
    public String toString()
    {
        return "HistoricalIncome{" +
            "year=" + year +
            ", individualincome=" + individualincome +
            ", householdincome=" + householdincome +
            '}';
    }
}
