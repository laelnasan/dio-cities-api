package br.com.nasan.citiesapi.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.nasan.citiesapi.cities.entity.City;

/**
 * CountryRepository
 */
public interface CityRepository extends JpaRepository<City, Long> {

  @Query(nativeQuery = true, value = "SELECT ((SELECT lat_lon FROM cidade WHERE id = ?1) <@> (SELECT lat_lon FROM cidade WHERE id = ?2)) as distance")
  Double distanceByPoints(final Long cityId1, final Long cityId2);

  @Query(nativeQuery = true, value = "SELECT earth_distance(ll_to_earth(?1, ?2), ll_to_earth(?3, ?4)) as distance")
  Double distanceByCube(final Double la1, final Double lo1, final Double la2, final Double lo2);
}
