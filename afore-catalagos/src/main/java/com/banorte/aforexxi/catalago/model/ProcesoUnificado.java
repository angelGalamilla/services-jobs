package com.banorte.aforexxi.catalago.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cat_proceso")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoUnificado implements Serializable {

  private static final long serialVersionUID = -7467052208260927634L;

  @Id
  @GeneratedValue
  @ApiModelProperty(
      notes = "The auto internal generated id by alert manager DB , not required to be entered by user into REST API ")
  @Column(name = "id_cat_proceso", nullable = false)
  private Integer idProceso;

  @Column(name = "clave")
  private String clave;

  @Column(name = "nombre")
  private String nombre;

}
