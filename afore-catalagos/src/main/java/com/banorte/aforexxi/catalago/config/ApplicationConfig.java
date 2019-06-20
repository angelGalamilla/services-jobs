/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationConfig.java
* Autor: rcruzcru
* Fecha de creación: 20/06/2019
*/
package com.banorte.aforexxi.catalago.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The Class ApplicationConfig.
 */
@Configuration
public class ApplicationConfig {

  /**
   * Model mapper.
   *
   * @return the model mapper
   */
  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
