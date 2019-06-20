/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ErrorHandler.java
* Autor: rcruzcru
* Fecha de creación: 20/06/2019
*/
package com.banorte.aforexxi.catalago.controller;

import static com.banorte.aforexxi.catalago.commons.Messages.getMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.banorte.aforexxi.catalago.dto.CustomErrorResponse;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.exceptions.NotAllowedOperationException;
import com.banorte.aforexxi.catalago.exceptions.ResourceNotFoundException;

/**
 * Generic error handling mechanism.
 *
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
    log.error("Exception {}", ex.getCode());
    log.error("Exception {}", ex.getMessage());
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

}
