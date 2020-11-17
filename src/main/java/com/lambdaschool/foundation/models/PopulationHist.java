package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "populationhist")
public class PopulationHist extends Auditable
{
    /**
     * Model for City's historical population data
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long popid;

    /**
     * Year of entry
     */
    @NotNull
    private int year;

    /**
     * City's average population
     */
    @NotNull
    private double pop;

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
    public PopulationHist()
    {
    }

    /**
     * Main constructor
     * @param year Year of entry
     * @param pop Average population
     * @param city City entry belongs to
     */
    public PopulationHist(
        @NotNull int year,
        @NotNull double pop,
        @NotNull City city)
    {
        this.year = year;
        this.pop = pop;
        this.city = city;
    }

    /**
     * Getters and setters for PopulationHist's fields
     *
     **********************************************************************************************/
    public long getPopid()
    {
        return popid;
    }

    public void setPopid(long popid)
    {
        this.popid = popid;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public double getPop()
    {
        return pop;
    }

    public void setPop(double pop)
    {
        this.pop = pop;
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
     * @return String of PopulationHist object
     */
    @Override
    public String toString()
    {
        return "PopulationHist{" +
            "year=" + year +
            ", pop=" + pop +
            '}';
    }
}
