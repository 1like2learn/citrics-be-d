package com.lambdaschool.foundation.controllers;

import com.lambdaschool.foundation.dtos.CityUpdater;
import com.lambdaschool.foundation.models.City;
import com.lambdaschool.foundation.models.CityIdName;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.CityService;
import com.lambdaschool.foundation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController
{
    /**
     * Conenction to city services
     */
    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    /**
     *  /all endpont (Not enough memory in free tier of
     *  Heroku to use with fully populated DB. Disabled until
     *  resources are available)
     * @return list of all cities
     */
//    @GetMapping(value = "/all",
//       produces = "application/json")
//    public ResponseEntity<?> listAllCities()
//    {
//        List<City> cities = cityService.findAll();
//        return  new ResponseEntity<>(cities, HttpStatus.OK);
//    }

    /**
     * /city/{cityid} endpoint
     * @param id cityid
     * @return city object matching cityid or throws exception
     */
    @GetMapping(value = "/city/{id}", produces = "application/json")
    public ResponseEntity<?> getCityById(@PathVariable Long id)
    {
        City c = cityService.findCityById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    /**
     * /allid endpoint
     * @return list of all City name's and id's
     */
    @GetMapping(value = "/allid", produces = "application/json")
    public ResponseEntity<?> listAllCityIds()
    {
        List<CityIdName> myList = cityService.findAllIds();

        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    /**
     * /avg endpoint
     * @return City with average fields of all cities
     */
    @GetMapping(value = "/avg", produces = "application/json")
    public ResponseEntity<?> getAverageCity()
    {
        City c = cityService.returnAverageCity();

        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    /**
     * /fav/{cityid} endpoint
     * this adds city to users fav cities
     * extracts user from token
     * @param cityid cityid to be added to favs
     * @param authentication used to extract user from token
     * @return null, 201 status
     */
    @PostMapping(value = "/fav/{cityid}")
    public ResponseEntity<?> addFavCity(
        @PathVariable long cityid,
        Authentication authentication
    )
    {
        User u = userService.findByName(authentication.getName());
        cityService.saveFavCity(cityid, u);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping(value = "/city/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> minModifyCity(@PathVariable long id, @RequestBody CityUpdater minCity)
    {
        //var returnCity = cityService.update(minCity);
        return new ResponseEntity<>(minCity, HttpStatus.OK);
    }
}
