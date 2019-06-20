/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: Messages.java
* Autor: rcruzcru
* Fecha de creación: 20/06/2019
*/
package com.banorte.aforexxi.catalago.commons;

import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Messages.
 */
public class Messages {

  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(Messages.class);

  /** The rb. */
  private static ResourceBundle rb =
      ResourceBundle.getBundle("com.banorte.xxi.catServices.messages.messages");
  
  /** The Constant BASE_ERROR_PROPERTY. */
  private static final String BASE_ERROR_PROPERTY = "messages.catServices.%s";


  /**
   * Instantiates a new messages.
   */
  private Messages() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Gets the messages.
   *
   * @param code the code
   * @return the messages
   */
  public static String getMessages(int code) {
    String message = "";
    try {
      String key = String.format(BASE_ERROR_PROPERTY, code);
      message = rb.getString(key);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    return message;
  }
}
