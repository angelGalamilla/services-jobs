package com.banorte.aforexxi.catalago.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

  /**
   * To string.
   *
   * @return the string
   */
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
