package br.com.nasan.citiesapi.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nasan.citiesapi.countries.entity.Country;

/**
 * CountryRepository
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
