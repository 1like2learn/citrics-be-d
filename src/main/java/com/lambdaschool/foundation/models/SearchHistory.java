package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "searchhistory")
public class SearchHistory extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;

    private Double populationMin;
    private Double populationMax;
    private Double salaryMin;
    private Double salaryMax;
    private Double rentMin;
    private Double rentMax;
    private Double avgTempMin;
    private Double avgTempMax;
    private Double walkabilityMin;
    private Double walkabilityMax;

    public SearchHistory(User user, double populationMin, double populationMax, double salaryMin, double salaryMax, double rentMin, double rentMax, double avgTempMin, double avgTempMax, double walkabilityMin, double walkabilityMax)
    {
        this.user = user;
        this.populationMin = populationMin;
        this.populationMax = populationMax;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.rentMin = rentMin;
        this.rentMax = rentMax;
        this.avgTempMin = avgTempMin;
        this.avgTempMax = avgTempMax;
        this.walkabilityMin = walkabilityMin;
        this.walkabilityMax = walkabilityMax;
    }

    public SearchHistory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPopulationMin() {
        return populationMin;
    }

    public void setPopulationMin(Double populationMin) {
        this.populationMin = populationMin;
    }

    public Double getPopulationMax() {
        return populationMax;
    }

    public void setPopulationMax(Double populationMax) {
        this.populationMax = populationMax;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Double getRentMin() {
        return rentMin;
    }

    public void setRentMin(Double rentMin) {
        this.rentMin = rentMin;
    }

    public Double getRentMax() {
        return rentMax;
    }

    public void setRentMax(Double rentMax) {
        this.rentMax = rentMax;
    }

    public Double getAvgTempMin() {
        return avgTempMin;
    }

    public void setAvgTempMin(Double avgTempMin) {
        this.avgTempMin = avgTempMin;
    }

    public Double getAvgTempMax() {
        return avgTempMax;
    }

    public void setAvgTempMax(Double avgTempMax) {
        this.avgTempMax = avgTempMax;
    }

    public Double getWalkabilityMin() {
        return walkabilityMin;
    }

    public void setWalkabilityMin(Double walkabilityMin) {
        this.walkabilityMin = walkabilityMin;
    }

    public Double getWalkabilityMax() {
        return walkabilityMax;
    }

    public void setWalkabilityMax(Double walkabilityMax) {
        this.walkabilityMax = walkabilityMax;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }
}
