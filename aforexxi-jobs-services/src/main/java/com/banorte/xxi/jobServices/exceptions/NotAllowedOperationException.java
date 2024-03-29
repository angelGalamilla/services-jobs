package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

import lombok.Getter;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 */
public class NotAllowedOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 173174093140313849L;
	@Getter
	private int code;

	/**
	 *
	 * @param message the message
	 */
	public NotAllowedOperationException(String message) {
	    super(message);
	}
	
	public NotAllowedOperationException(int code) {
	    super(getMessages(code));
	    this.code = code;
	}
}
