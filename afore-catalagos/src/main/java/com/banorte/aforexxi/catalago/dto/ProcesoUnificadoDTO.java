package com.banorte.aforexxi.catalago.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoUnificadoDTO {

  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private Integer id;

  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private String clave;

  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private String nombre;

}
