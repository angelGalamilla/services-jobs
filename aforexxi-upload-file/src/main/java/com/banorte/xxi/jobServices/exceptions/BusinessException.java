/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: BusinessException.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;
import lombok.Getter;

/**
 * The Class BusinessException.
 */
public class BusinessException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -7830442974839430L;
  
  @Getter
  private int code;
  
  /**
   * Instantiates a new business exception.
   *
   * @param message the message
   */
  public BusinessException(String message) {
    super(message);
  }

  /**
   * Instantiates a new business exception.
   *
   * @param code the code
   */
  public BusinessException(int code) {
    super(getMessages(code));
    this.code = code;
  }
}
