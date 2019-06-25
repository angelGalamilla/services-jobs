/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationEntry.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationEntry {

  /** The id notificacion. */
  @ApiModelProperty(
      notes = "the key value alert content for application item description required to be entered by user into REST API ",
      required = true)
  private int idNotificacion;

  /** The motivo. */
  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private String motivo;

}
