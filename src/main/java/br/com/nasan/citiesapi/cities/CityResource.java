package br.com.nasan.citiesapi.cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nasan.citiesapi.cities.entity.City;
import br.com.nasan.citiesapi.cities.repository.CityRepository;

@RestController
@RequestMapping("/cities")
class CityResource {

  @Autowired
  private CityRepository repository;

  @GetMapping
  public Page<City> getPage(Pageable page) {
    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity getOne(@PathVariable Long id) {
    Optional<City> optionalCity = repository.findById(id);

    return optionalCity.isPresent()
        ? ResponseEntity.ok().body(optionalCity.get())
        : ResponseEntity.notFound().build();
  }

  @GetMapping("/{from}/distance-to/{to}")
  public ResponseEntity getDistance(@PathVariable Long from, @PathVariable Long to,
      @RequestParam(required = false) Boolean showcities) {
    Optional<City> optionalCityFrom = repository.findById(from);
    Optional<City> optionalCityTo = repository.findById(to);

    if (optionalCityFrom.isPresent() && optionalCityTo.isPresent()) {
      City cityFrom = optionalCityFrom.get();
      City cityTo = optionalCityTo.get();

      Map<String, Object> response = new HashMap<String, Object>();
      response.put("distace-by-points", repository.distanceByPoints(cityFrom.getId(), cityTo.getId()));

      if (showcities != null && showcities) {
        List<City> cities = new ArrayList<City>();
        cities.add(cityFrom);
        cities.add(cityTo);

        response.put("cities", cities);
      }

      return ResponseEntity.ok().body(response);
    }

    return ResponseEntity.notFound().build();
  }

}
