package com.banorte.aforexxi.catalago.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

/**
 * Necessary for proper Swagger documentation.
 *
 */
@AllArgsConstructor
@Getter
public class CustomErrorResponse implements Serializable {

  private static final long serialVersionUID = -7755563009111273632L;

  private int status;

  private String errorMessage;

}
