package br.com.nasan.citiesapi.states.entity;

import java.util.List;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.com.nasan.citiesapi.countries.entity.Country;

/**
 * State
 */
@Entity
@Table(name = "estado")
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {
  @Id
  private Long id;

  @Column(name = "nome")
  private String name;

  @Column(name = "uf")
  private String code;

  @ManyToOne
  @JoinColumn(name = "pais", referencedColumnName = "id")
  private Country country;

  private Integer ibge;

  @Type(type = "jsonb")
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "ddd", columnDefinition = "jsonb")
  private List<Integer> ddd;

  public State() {
  } // empty constructor

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public Integer getIbge() {
    return ibge;
  }

  public Country getCountryId() {
    return country;
  }

  public List<Integer> getDdd() {
    return ddd;
  }

}
