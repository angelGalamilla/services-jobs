/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: SubProcesoController.java
* Autor: rcruzcru
* Fecha de creación: 20/06/2019
*/
package com.banorte.aforexxi.catalago.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.banorte.aforexxi.catalago.dto.CustomErrorResponse;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;
import com.banorte.aforexxi.catalago.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by.
 */
@RestController
@RequestMapping("/catServices")
@Api(value = "Applciation SubProcess Catalog")
public class SubProcesoController {

  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(SubProcesoController.class);

  /** The application service. */
  @Autowired
  private ApplicationService applicationService;

  /**
   * Gets the all sub procesos.
   *
   * @return the all sub procesos
   */
  @GetMapping(value = "/getSubProcesos", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "view the list of ALL current active created stored subProcesos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = SubProcesoDTO.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<List<SubProcesoDTO>> getAllSubProcesos() {
    log.debug("Trying to retrieve all subProcesos");
    List<SubProcesoDTO> listSubProcesos = applicationService.getAllSubProcesos();
    return new ResponseEntity<>(listSubProcesos, HttpStatus.OK);

  }

  /**
   * Gets the sub procesoby id proceso.
   *
   * @param idProceso the id proceso
   * @return the sub procesoby id proceso
   */
  @GetMapping(value = "/getSubProcesos/{idProceso}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(
      value = "view the list of ALL current active created stored subProcesos by IdProcess",
      response = SubProcesoDTO.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = SubProcesoDTO.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<List<SubProcesoDTO>> getSubProcesobyIdProceso(
      @PathVariable("idProceso") Integer idProceso) {

    log.debug("Trying to retrieve all SubProcess by IdProcess");
    log.info("Id Proceso: {}", idProceso);
    List<SubProcesoDTO> listSubProcesos = applicationService.getSubProcesosByIdProcess(idProceso);


    return new ResponseEntity<>(listSubProcesos, HttpStatus.OK);
  }

}
