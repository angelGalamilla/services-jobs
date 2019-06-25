/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: NotAllowedOperationException.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

import lombok.Getter;

/**
 * The Class NotAllowedOperationException.
 */
public class NotAllowedOperationException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 173174093140313849L;
	
	@Getter
	private int code;

	/**
	 * Instantiates a new not allowed operation exception.
	 *
	 * @param message the message
	 */
	public NotAllowedOperationException(String message) {
	    super(message);
	}
	
	/**
	 * Instantiates a new not allowed operation exception.
	 *
	 * @param code the code
	 */
	public NotAllowedOperationException(int code) {
	    super(getMessages(code));
	    this.code = code;
	}
}
