package br.com.nasan.citiesapi.countries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nasan.citiesapi.countries.entity.Country;
import br.com.nasan.citiesapi.countries.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
class CountryResource {

  @Autowired
  private CountryRepository repository;

  @GetMapping
  public List<Country> countries() {
    return repository.findAll();
  }

}
