/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationController.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/

package com.banorte.xxi.jobServices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.banorte.xxi.jobServices.dto.ApplicationEntry;
import com.banorte.xxi.jobServices.dto.ApplicationResponse;
import com.banorte.xxi.jobServices.dto.CustomErrorResponse;
import com.banorte.xxi.jobServices.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/catServices")
@Api(value = "Applciation jobServices")
public class ApplicationController {

  private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

  private ApplicationService applicationService;

  @Autowired
  public ApplicationController(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = ApplicationResponse.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  @PostMapping("/carga")
  public ResponseEntity<ApplicationResponse> handleFileUpload(
      @RequestParam("file") MultipartFile file, @RequestParam("idNotificacion") int idNotificacion,
      @RequestParam("motivo") String motivo) {

    log.info("{ file: {}, id_totificacio: {}, motivo: {} }", file.getName(), idNotificacion,
        motivo);
    ApplicationEntry applicationEntry = new ApplicationEntry(idNotificacion, motivo);
    boolean succes = applicationService.storeFile(file, applicationEntry);
    ApplicationResponse applicationResponse = new ApplicationResponse();
    applicationResponse.setStatus(succes);

    return new ResponseEntity<>(applicationResponse, HttpStatus.OK);
  }

}
