/*
 * (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
 *
 * Este archivo contiene información que es exclusivo de Afore XXI Banorte y se considera
 * confidencial. Esta estrictamente prohibido copiar o compartir de manera total o parcial en
 * cualquier formato, ya sea mecánico o electrónico.
 *
 * Nombre de archivo: ErrorHandler.java Autor: rcruzcru Fecha de creación: 20/06/2019
 */
package com.banorte.aforexxi.catalago.controller;

import static com.banorte.aforexxi.catalago.commons.Messages.getMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.banorte.aforexxi.catalago.dto.CustomErrorResponse;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.exceptions.NotAllowedOperationException;
import com.banorte.aforexxi.catalago.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * Generic error handling mechanism.
 *
 */
@ControllerAdvice
@Slf4j
public class ErrorHandler {

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<CustomErrorResponse> handleNotFound(ResourceNotFoundException ex) {
    log.error("Entity was not found", ex);
    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getCode(), ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }


  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ExceptionHandler(NotAllowedOperationException.class)
  public ResponseEntity<CustomErrorResponse> handleNotFound(NotAllowedOperationException ex) {
    log.error("Not Allowed operation", ex);
    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getCode(), ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<CustomErrorResponse> handleNotFound(BusinessException ex) {
    log.error("Exception {}", ex.getCode());
    log.error("Exception {}", ex.getMessage());
    log.error("BusinessException", ex);
    CustomErrorResponse errorResponse = new CustomErrorResponse(ex.getCode(), ex.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
  }

  /**
   * Handle not found.
   *
   * @param ex the ex
   * @return the custom error response
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<CustomErrorResponse> handleNotFound(RuntimeException ex) {
    log.error("Generic exception", ex);
    CustomErrorResponse errorResponse = new CustomErrorResponse(500, getMessages(2));
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
