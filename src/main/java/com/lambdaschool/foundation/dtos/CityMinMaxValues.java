package com.lambdaschool.foundation.dtos;

public class CityMinMaxValues {
    private Double populationMin;
    private Double populationMax;
    private Double salaryMin;
    private Double salaryMax;
    private Double rentMin;
    private Double rentMax;
    private Double avgTempMin;
    private Double avgTempMax;

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

    @Override
    public String toString() {
        return "CityMinMaxValues{" +
                "populationMin=" + populationMin +
                ", populationMax=" + populationMax +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", rentMin=" + rentMin +
                ", rentMax=" + rentMax +
                ", avgTempMin=" + avgTempMin +
                ", avgTempMax=" + avgTempMax +
                '}';
    }
}
