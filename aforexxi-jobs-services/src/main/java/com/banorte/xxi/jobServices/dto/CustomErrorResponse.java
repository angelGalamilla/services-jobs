package com.banorte.xxi.jobServices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

/**
 * Necessary for proper Swagger documentation.
 *
 */
@SuppressWarnings("unused")
@AllArgsConstructor
@Getter
public class CustomErrorResponse implements Serializable {

    private static final long serialVersionUID = -7755563009111273632L;

    private int status;

    private String errorMessage;

}
