/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ProcesoUnificadoController.java
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
import com.banorte.aforexxi.catalago.dto.ProcesoUnificadoDTO;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;
import com.banorte.aforexxi.catalago.service.ProcesoUnificadoService;
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
public class ProcesoUnificadoController {

  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(ProcesoUnificadoController.class);

  /** The service. */
  @Autowired
  private ProcesoUnificadoService service;

  /**
   * Gets the all proceso unificado.
   *
   * @return the all proceso unificado
   */
  @GetMapping(value = "/getProcesoUnificado", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "view the list of ALL current active created stored subProcesos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = ProcesoUnificadoDTO.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<List<ProcesoUnificadoDTO>> getAllProcesoUnificado() {
    log.debug("Trying to retrieve all subProcesos");
    List<ProcesoUnificadoDTO> listSubProcesos = service.getAllProcesoUnificado();
    return new ResponseEntity<>(listSubProcesos, HttpStatus.OK);

  }

  /**
   * Gets the proceso unificado by id proceso.
   *
   * @param idProceso the id proceso
   * @return the proceso unificado by id proceso
   */
  @GetMapping(value = "/getProcesoUnificado/{idProceso}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "view the current active created stored subProcesos by IdProcess",
      response = SubProcesoDTO.class)
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Success", response = ProcesoUnificadoDTO.class),
          @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
          @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
          @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<ProcesoUnificadoDTO> getProcesoUnificadoByIdProceso(
      @PathVariable("idProceso") Integer idProceso) {

    log.debug("Trying to retrieve all SubProcess by IdProcess");
    log.info("Id Proceso: {}", idProceso);
    ProcesoUnificadoDTO procesoUnificado = service.getProcesoUnificadoById(idProceso);


    return new ResponseEntity<>(procesoUnificado, HttpStatus.OK);
  }
}
