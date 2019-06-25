/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationItem.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.model;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Map;

/**
 * The Class ApplicationItem.
 */
@Entity
@Table(name = "ESPECIFICACION_ARCHIVO")

@Builder
@NoArgsConstructor
/**
 * Instantiates a new application item.
 *
 * @param idEspArc the id esp arc
 * @param idNotificacion the id notificacion
 * @param motivo the motivo
 */
@AllArgsConstructor
public class ApplicationItem implements Serializable {

  /** The id esp arc. */
  @Id
  @SequenceGenerator(name = "espevcificacionSequence", sequenceName = "espevcificacionSequence",
      allocationSize = 10)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "espevcificacionSequence")
  @Column(name = "ID_ESPECIFICACION_ARCHIVO")
  private Long idEspArc;

  /** The id notificacion. */
  @Column(name = "FK_ID_CAT_TIPO_OPERACION")
  @ApiModelProperty(
      notes = "the key value alert content for application item description required to be entered by user into REST API ",
      required = true)
  private int idNotificacion;

  /** The motivo. */
  @Column(name = "DESCRIPCION", length = 5)
  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private String motivo;

}
