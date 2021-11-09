package br.com.nasan.citiesapi.countries.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Country
 */
@Entity
@Table(name = "pais")
public class Country {
  @Id
  private long id;

  @Column(name = "nome")
  private String name;

  @Column(name = "nome_pt")
  private String name_pt;

  @Column(name = "sigla")
  private String code;

  private int bacen;

  public Country() {
  } // empty constructor

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getName_pt() {
    return name_pt;
  }

  public String getCode() {
    return code;
  }

  public int getBacen() {
    return bacen;
  }

}
