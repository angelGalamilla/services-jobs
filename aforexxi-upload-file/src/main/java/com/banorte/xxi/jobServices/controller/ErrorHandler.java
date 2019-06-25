/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ErrorHandler.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/

package com.banorte.xxi.jobServices.controller;

import com.banorte.xxi.jobServices.dto.CustomErrorResponse;
import org.slf4j.Logger;
import com.banorte.xxi.jobServices.exceptions.*;
import com.banorte.xxi.jobServices.commons.Messages;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

/**
 * The Class ErrorHandler.
 */
@ControllerAdvice
public class ErrorHandler {

  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ResponseStatus(HttpStatus.NOT_FOUND) // 404
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseBody
  public CustomErrorResponse handleNotFound(ResourceNotFoundException ex) {
    log.error("Entity was not found", ex);
    return new CustomErrorResponse(ex.getCode(), ex.getMessage());
  }


  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
  @ExceptionHandler(NotAllowedOperationException.class)
  @ResponseBody
  public CustomErrorResponse handleNotFound(NotAllowedOperationException ex) {
    log.error("Not Allowed operation", ex);
    return new CustomErrorResponse(ex.getCode(), ex.getMessage());
  }

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ResponseStatus(HttpStatus.CONFLICT) // 409
  @ExceptionHandler(BusinessException.class)
  @ResponseBody
  public CustomErrorResponse handleNotFound(BusinessException ex) {
    log.error("Exception ", ex.getCode());
    log.error("Exception ", ex.getMessage());
    log.error("BusinessException", ex);
    return new CustomErrorResponse(ex.getCode(), ex.getMessage());
  }

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  public CustomErrorResponse handleNotFound(RuntimeException ex) {
    log.error("Generic exception", ex);
    return new CustomErrorResponse(500, getMessages(2));
  }

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
  @ExceptionHandler(StorageException.class)
  @ResponseBody
  public CustomErrorResponse handleNotFound(StorageException ex) {
    log.error("Storage Exception: ", ex);
    return new CustomErrorResponse(500, getMessages(2));
  }

}
