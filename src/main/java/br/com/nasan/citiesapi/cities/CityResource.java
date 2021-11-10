package br.com.nasan.citiesapi.cities;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    Optional<City> optional = repository.findById(id);

    return optional.isPresent()
        ? ResponseEntity.ok().body(optional.get())
        : ResponseEntity.notFound().build();
  }

}
