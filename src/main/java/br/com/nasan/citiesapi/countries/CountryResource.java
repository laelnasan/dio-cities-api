package br.com.nasan.citiesapi.countries;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public Page<Country> getPage(Pageable page) {
    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity getOne(@PathVariable Long id) {
    Optional<Country> optional = repository.findById(id);

    return optional.isPresent()
        ? ResponseEntity.ok().body(optional.get())
        : ResponseEntity.notFound().build();
  }

}
