package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "counties")
public class County extends Auditable
{
    /**
     * Id used for counties table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long countyid;

    /**
     * County's name
     */
    @NotNull
    private String name;

    /**
     * City the County is located
     */
    @ManyToOne
    @JoinColumn(name = "cityid")
    @NotNull
    @JsonIgnore
    private City city;

    /**
     * Default constructor
     */
    public County()
    {
    }

    /**
     * Main constructor
     * @param name County name
     * @param city County City
     */
    public County(
        @NotNull String name,
        @NotNull City city)
    {
        this.name = name;
        this.city = city;
    }

    /**
     * Getters and setters for County's fields
     *
     ******************************************************************************************/

    public long getCountyid()
    {
        return countyid;
    }

    public void setCountyid(long countyid)
    {
        this.countyid = countyid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
     * @return
     */
    @Override
    public String toString()
    {
        return "County{" +
            "name='" + name + '\'' +
            '}';
    }
}
