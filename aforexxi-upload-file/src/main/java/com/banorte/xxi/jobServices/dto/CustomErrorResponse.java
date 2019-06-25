/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: CustomErrorResponse.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@SuppressWarnings("unused")
@AllArgsConstructor
@Getter
public class CustomErrorResponse implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -7755563009111273632L;

  /** The status. */
  private int status;

  /** The error message. */
  private String errorMessage;

}
