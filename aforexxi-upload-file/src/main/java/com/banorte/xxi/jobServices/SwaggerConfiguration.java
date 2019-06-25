/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: SwaggerConfiguration.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  /**
   * Api.
   *
   * @return the docket
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any()).build().apiInfo(apiInfo());
  }

  /**
   * Api info.
   *
   * @return the api info
   */
  private ApiInfo apiInfo() {
    ApiInfo apiInfo =
        new ApiInfo("Application REST API", "Application manager REST API documentation.",
            "API 1.0", "Terms of service based into company terms of use",
            new Contact("Capgemini", null, "test@test.com"),
            "License of API for YourCompany use only", null, Collections.emptyList());
    return apiInfo;
  }
}
