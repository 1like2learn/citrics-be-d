package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.dtos.CityInfoInterface;
import com.lambdaschool.foundation.models.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long>
{
    /**
     * Finds city by the citynamestate field
     * @param cityname name of city
     * @return City matching cityname
     */
    City findByCitynamestate(String cityname);

    List<City> findByPopulationGreaterThanEqualAndPopulationLessThanEqual(long popMax, long popMin);
    List<City> findByRentGreaterThanEqualAndRentLessThanEqual(long rentMin, long rentMax);
    List<City> findByIndividualincomeGreaterThanEqualAndIndividualincomeLessThanEqual(double salMax, double salMin);
    List<City> findByAveragetempGreaterThanEqualAndAveragetempLessThanEqual(double avgTempMin, double avgTempMax);

    /* Get minmax values for all advanced search fields */
    City findFirstByOrderByPopulationDesc();
    City findFirstByOrderByPopulationAsc();

    City findFirstByOrderByIndividualincomeAsc();
    City findFirstByOrderByIndividualincomeDesc();

    City findFirstByOrderByRentAsc();
    City findFirstByOrderByRentDesc();

    City findFirstByAveragetempLessThanOrderByAveragetempAsc(Double notANumber);
    City findFirstByAveragetempLessThanOrderByAveragetempDesc(Double notANumber);


    /* ADVANCED SEARCH QUERY */

    @Query(nativeQuery = true, value = "SELECT cityid, citynamestate " +
                                        "FROM cities " +
                                        "WHERE population >= :populationMin AND population <= :populationMax " +
                                        "AND individualincome >= :salaryMin AND individualincome <= :salaryMax " +
                                        "AND rent >= :rentMin AND rent <= :rentMax " +
                                        "AND averagetemp >= :avgTempMin AND averagetemp <= :avgTempMax")
    List<CityInfoInterface> advancedSearch(@Param("populationMin") double popMin,
                                           @Param("populationMax") double popMax,
                                           @Param("salaryMin") double salaryMin,
                                           @Param("salaryMax") double salaryMax,
                                           @Param("rentMin") double rentMin,
                                           @Param("rentMax") double rentMax,
                                           @Param("avgTempMin") double tempMin,
                                           @Param("avgTempMax") double tempMax);
}
