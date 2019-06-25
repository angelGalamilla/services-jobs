/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ResourceNotFoundException.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

import lombok.Getter;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

  @Getter
  private int code = 404;

  /**
   * Instantiates a new resource not found exception.
   *
   * @param code the code
   */
  public ResourceNotFoundException(int code) {
    super(getMessages(code));
  }
}
