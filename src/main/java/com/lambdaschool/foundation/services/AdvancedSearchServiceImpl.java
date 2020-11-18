package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.dtos.CityInfoInterface;
import com.lambdaschool.foundation.dtos.CityMinMaxValues;
import com.lambdaschool.foundation.models.City;
import com.lambdaschool.foundation.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvancedSearchServiceImpl implements AdvancedSearchService
{

    @Autowired
    CityService cityService;

    @Autowired
    CityRepository cityRepository;

    @Override
    public CityMinMaxValues getMinMax()
    {
        var minMax = new CityMinMaxValues();

        var popMax = cityRepository.findFirstByOrderByPopulationDesc();
        var popMin = cityRepository.findFirstByOrderByPopulationAsc();
        var salMin = cityRepository.findFirstByOrderByPopulationAsc();
        var salMax = cityRepository.findFirstByOrderByPopulationDesc();
        var rentMin = cityRepository.findFirstByOrderByRentAsc();
        var rentMax = cityRepository.findFirstByOrderByRentDesc();
        var tempMin = cityRepository.findFirstByAveragetempLessThanOrderByAveragetempAsc(Double.MAX_VALUE);
        var tempMax = cityRepository.findFirstByAveragetempLessThanOrderByAveragetempDesc(Double.MAX_VALUE);

        minMax.setPopulationMin(popMin.getPopulation());
        minMax.setPopulationMax(popMax.getPopulation());
        minMax.setSalaryMin(salMin.getIndividualincome());
        minMax.setSalaryMax(salMax.getIndividualincome());
        minMax.setRentMin(rentMin.getRent());
        minMax.setRentMax(rentMax.getRent());
        minMax.setAvgTempMin(tempMin.getAveragetemp());
        minMax.setAvgTempMax(tempMax.getAveragetemp());

        return minMax;
    }

    @Override
    public List<City> filterBySalary(Double min, Double max) {
        return null;
    }

    @Override
    public List<City> filterByRent(Double min, Double max) {
        return null;
    }

    @Override
    public List<City> filterByAvgTemp(Double min, Double max) {
        return null;
    }

    @Override
    public List<City> filterByPopulation(Double min, Double max) {
        return null;
    }

    @Override
    public List<CityInfoInterface> advancedSearch(CityMinMaxValues searchParams) {
        var minMaxValues = getMinMax();
        if (searchParams.getRentMax() == null || searchParams.getRentMin() == null) {
            searchParams.setRentMin(minMaxValues.getRentMin());
            searchParams.setRentMax(minMaxValues.getRentMax());
        }
        if (searchParams.getSalaryMax() == null || searchParams.getSalaryMin() == null)
        {
            searchParams.setSalaryMin(minMaxValues.getSalaryMin());
            searchParams.setSalaryMax(minMaxValues.getSalaryMax());
        }
        if (searchParams.getAvgTempMax() == null || searchParams.getAvgTempMin() == null)
        {
            searchParams.setAvgTempMin(minMaxValues.getAvgTempMin());
            searchParams.setAvgTempMax(minMaxValues.getAvgTempMax());
        }
        if (searchParams.getPopulationMax() == null || searchParams.getPopulationMin() == null)
        {
            searchParams.setPopulationMax(minMaxValues.getPopulationMax());
            searchParams.setPopulationMin(minMaxValues.getPopulationMin());
        }

        // For debugging
//        System.out.println(searchParams);

        var result = cityRepository.advancedSearch(searchParams.getPopulationMin(),
                searchParams.getPopulationMax(),
                searchParams.getSalaryMin(),
                searchParams.getSalaryMax(),
                searchParams.getRentMin(),
                searchParams.getRentMax(),
                searchParams.getAvgTempMin(),
                searchParams.getAvgTempMax());

        return result;
    }
}
