package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

import lombok.Getter;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7830442974839430L;
	@Getter
	private int code;
    /**
     *
     * @param message the message
     */
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(int code) {
    	super(getMessages(code));
    	this.code = code;
    }
}
