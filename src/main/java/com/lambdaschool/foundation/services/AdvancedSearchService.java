package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.dtos.CityInfoInterface;
import com.lambdaschool.foundation.dtos.CityMinMaxValues;
import com.lambdaschool.foundation.models.City;

import java.util.List;

public interface AdvancedSearchService {
    CityMinMaxValues getMinMax();

    List<City> filterBySalary(Double min, Double max);
    List<City> filterByRent(Double min, Double max);
    List<City> filterByAvgTemp(Double min, Double max);
    List<City> filterByPopulation(Double min, Double max);

    List<CityInfoInterface> advancedSearch(CityMinMaxValues searchParams);
}
