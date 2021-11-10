package br.com.nasan.citiesapi.cities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import br.com.nasan.citiesapi.states.entity.State;

/**
 * City
 */
@Entity
@Table(name = "cidade")
@TypeDefs(value = {
    @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {
  @Id
  private long id;

  @Column(name = "nome")
  private String name;

  @ManyToOne
  @JoinColumn(name = "uf", referencedColumnName = "id")
  private State state;

  @Column(name = "cod_tom")
  private Integer code;

  private int ibge;

  private double latitude;

  private double longitude;

  @Type(type = "point")
  @Column(name = "lat_lon")
  private Point location;

  public City() {
  } // empty constructor

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public State getState() {
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

  public Point getLocation() {
    return location;
  }

}
