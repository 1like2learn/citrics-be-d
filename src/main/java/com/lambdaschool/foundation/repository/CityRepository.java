package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long>
{
    /**
     * Finds city by the citynamestate field
     * @param cityname name of city
     * @return City matching cityname
     */
    City findByCitynamestate(String cityname);
}
