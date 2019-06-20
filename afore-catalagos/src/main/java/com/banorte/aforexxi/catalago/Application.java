/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: Application.java
* Autor: rcruzcru
* Fecha de creación: 20/06/2019
*/
package com.banorte.aforexxi.catalago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class Application.
 */
@SpringBootApplication
@EnableScheduling
public class Application {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
