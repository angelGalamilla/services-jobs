/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: StorageException.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.exceptions;

/**
 * The Class StorageException.
 */
public class StorageException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new storage exception.
   *
   * @param message the message
   */
  public StorageException(String message) {
    super(message);
  }

  /**
   * Instantiates a new storage exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public StorageException(String message, Throwable cause) {
    super(message, cause);
  }
}
