package com.banorte.aforexxi.catalago.dto;

import java.io.Serializable;
import com.banorte.aforexxi.catalago.model.SubProceso;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TramiteDTO implements Serializable {

  private static final long serialVersionUID = -5764840068069952328L;

  private Integer idTramite;

  private String clave;

  private String nombre;

  private SubProceso subproceso;
  
  @ApiModelProperty(notes = "Applciation code required to be entered by user into REST API ",
      required = true)
  private Integer activo;

}

