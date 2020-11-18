package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.dtos.CityMinMaxValues;
import com.lambdaschool.foundation.services.AdvancedSearchService;
import com.lambdaschool.foundation.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.awt.*;

@RestController
@RequestMapping(path = "/cities/advancedsearch")
public class AdvancedCityController {
    @Autowired
    CityService cityService;

    @Autowired
    AdvancedSearchService advancedSearchService;

    // /cities/advancedsearch?popMin=21344&popMax=234234&rentMin=234234&rentMax=23432
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> advancedSearch(@RequestParam(required = false) Double popMin, @RequestParam(required = false) Double popMax,
                                            @RequestParam(required = false) Double rentMin, @RequestParam(required = false) Double rentMax,
                                            @RequestParam(required = false) Double salMin, @RequestParam(required = false) Double salMax,
                                            @RequestParam(required = false) Double avgTempMin, @RequestParam(required = false) Double avgTempMax)
    {

        if(popMax != null && popMin == null || popMin != null && popMax == null)
        {
            throw new EntityNotFoundException("Both popMin and popMax are required");
        }
        if(rentMin != null && rentMax == null || rentMax != null && rentMin == null)
        {
            throw new EntityNotFoundException("Both rentMin and rentMax are required");
        }
        if(salMin != null && salMax == null || salMax != null && salMin == null)
        {
            throw new EntityNotFoundException("Both salMin and salMax are required");
        }
        if(avgTempMax != null && avgTempMin == null || avgTempMin != null && avgTempMax == null)
        {
            throw new EntityNotFoundException("Both avgTempMin and avgTempMax are required");
        }

        CityMinMaxValues minMax = new CityMinMaxValues();
        minMax.setAvgTempMax(avgTempMax);
        minMax.setAvgTempMin(avgTempMin);
        minMax.setRentMin(rentMin);
        minMax.setRentMax(rentMax);
        minMax.setSalaryMax(salMax);
        minMax.setSalaryMin(salMin);
        minMax.setPopulationMin(popMin);
        minMax.setPopulationMax(popMax);

        var cityList = advancedSearchService.advancedSearch(minMax);

        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @GetMapping(path = "/minmax", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMinMaxValues()
    {
        var minMax = advancedSearchService.getMinMax();
        return new ResponseEntity<>(minMax, HttpStatus.OK);
    }
}
