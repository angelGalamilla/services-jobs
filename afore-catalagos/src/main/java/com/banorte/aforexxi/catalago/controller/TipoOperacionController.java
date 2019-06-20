/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: TipoOperacionController.java
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
import com.banorte.aforexxi.catalago.dto.TipoOperacionDTO;
import com.banorte.aforexxi.catalago.service.TipoOperacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by.
 */
@RestController
@RequestMapping("/catServices")
@Api(value = "Applciation Tramite Catalog")
public class TipoOperacionController {

  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(TipoOperacionController.class);

  /** The service. */
  @Autowired
  private TipoOperacionService service;

  /**
   * Gets the all tramites.
   *
   * @return the all tramites
   */
  @GetMapping(value = "/getTipoOperacion", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(value = "view the list of ALL current active created stored Tipo Operacion")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = TipoOperacionDTO.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<List<TipoOperacionDTO>> getAllTramites() {
    log.debug("Trying to retrieve all subProcesos");
    List<TipoOperacionDTO> listaTramite = service.getAllTipoOperacion();
    return new ResponseEntity<>(listaTramite, HttpStatus.OK);

  }

  /**
   * Gets the tramiteby id proceso.
   *
   * @param idTramite the id tramite
   * @return the tramiteby id proceso
   */
  @GetMapping(value = "/getTipoOperacion/{idTramite}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ApiOperation(
      value = "view the list of ALL current active created stored Tipo Operacion by idTramite",
      response = SubProcesoDTO.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success", response = TipoOperacionDTO.class,
          responseContainer = "List"),
      @ApiResponse(code = 400, message = "Bad Request", response = CustomErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found", response = CustomErrorResponse.class),
      @ApiResponse(code = 500, message = "Failure", response = CustomErrorResponse.class)})
  public ResponseEntity<List<TipoOperacionDTO>> getTramitebyIdProceso(
      @PathVariable("idTramite") Integer idTramite) {

    log.debug("Trying to retrieve all SubProcess by IdProcess");
    log.info("Id Proceso: {}", idTramite);
    List<TipoOperacionDTO> listaTramite = service.getTipoOperacionByIdTramite(idTramite);


    return new ResponseEntity<>(listaTramite, HttpStatus.OK);
  }

}
