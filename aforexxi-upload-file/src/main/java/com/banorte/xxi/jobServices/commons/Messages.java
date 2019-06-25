/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: Messages.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/

package com.banorte.xxi.jobServices.commons;

import java.util.ResourceBundle;

public class Messages {

  private static ResourceBundle rb =
      ResourceBundle.getBundle("com.banorte.xxi.jobServices.messages.messages");
  private static final String BASE_ERROR_PROPERTY = "messages.jobServices.%s";

  public static String getMessages(int code) {
    String message = "";
    try {
      String key = String.format(BASE_ERROR_PROPERTY, code);
      message = rb.getString(key);
    } catch (Exception e) {
    }
    return message;
  }
}
