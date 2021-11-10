package br.com.nasan.citiesapi.states.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nasan.citiesapi.states.entity.State;

/**
 * CountryRepository
 */
public interface StateRepository extends JpaRepository<State, Long> {

}
