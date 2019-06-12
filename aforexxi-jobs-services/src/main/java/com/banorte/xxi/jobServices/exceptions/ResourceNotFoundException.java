package com.banorte.xxi.jobServices.exceptions;

import static com.banorte.xxi.jobServices.commons.Messages.getMessages;

import lombok.Getter;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	@Getter
	private int code = 404;
	
    /**
     *
     * @param message the message
     */
	public ResourceNotFoundException(int code) {
        super(getMessages(code));
    }
}
