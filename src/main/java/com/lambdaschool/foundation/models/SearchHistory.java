package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "searchhistory")
public class SearchHistory extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnoreProperties
    private User user;

    private double populationMin;
    private double populationMax;
    private double salaryMin;
    private double salaryMax;
    private double rentMin;
    private double rentMax;
    private double avgTempMin;
    private double avgTempMax;
    private double walkabilityMin;
    private double walkabilityMax;

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

    public double getPopulationMin() {
        return populationMin;
    }

    public void setPopulationMin(double populationMin) {
        this.populationMin = populationMin;
    }

    public double getPopulationMax() {
        return populationMax;
    }

    public void setPopulationMax(double populationMax) {
        this.populationMax = populationMax;
    }

    public double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public double getRentMin() {
        return rentMin;
    }

    public void setRentMin(double rentMin) {
        this.rentMin = rentMin;
    }

    public double getRentMax() {
        return rentMax;
    }

    public void setRentMax(double rentMax) {
        this.rentMax = rentMax;
    }

    public double getAvgTempMin() {
        return avgTempMin;
    }

    public void setAvgTempMin(double avgTempMin) {
        this.avgTempMin = avgTempMin;
    }

    public double getAvgTempMax() {
        return avgTempMax;
    }

    public void setAvgTempMax(double avgTempMax) {
        this.avgTempMax = avgTempMax;
    }

    public double getWalkabilityMin() {
        return walkabilityMin;
    }

    public void setWalkabilityMin(double walkabilityMin) {
        this.walkabilityMin = walkabilityMin;
    }

    public double getWalkabilityMax() {
        return walkabilityMax;
    }

    public void setWalkabilityMax(double walkabilityMax) {
        this.walkabilityMax = walkabilityMax;
    }
}
