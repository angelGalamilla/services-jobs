package com.banorte.aforexxi.catalago.exceptions;

import static com.banorte.aforexxi.catalago.commons.Messages.getMessages;
import lombok.Getter;

/**
 * This exception should be thrown in all cases when a resource cannot be found
 *
 */
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7624924643639776290L;

  @Getter
  private final int code = 404;

  /**
   *
   * @param message the message
   */
  public ResourceNotFoundException(int code) {
    super(getMessages(code));
  }
}
