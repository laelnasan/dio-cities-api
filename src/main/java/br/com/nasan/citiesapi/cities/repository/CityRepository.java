package br.com.nasan.citiesapi.cities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nasan.citiesapi.cities.entity.City;

/**
 * CountryRepository
 */
public interface CityRepository extends JpaRepository<City, Long> {

}
