package br.com.nasan.citiesapi.cities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * City
 */
@Entity
@Table(name = "cidade")
public class City {
  @Id
  private long id;

  @Column(name = "nome")
  private String name;

  @Column(name = "uf")
  private Integer state;

  @Column(name = "cod_tom")
  private Integer code;

  private int ibge;

  private double latitude;

  private double longitude;

  public City() {
  } // empty constructor

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getState() {
    return state;
  }

  public Integer getCode() {
    return code;
  }

  public int getIbge() {
    return ibge;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

}
