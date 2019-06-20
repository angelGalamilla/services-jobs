package com.banorte.aforexxi.catalago.dto;

import java.io.Serializable;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoOperacionDTO implements Serializable {

  private static final long serialVersionUID = -1134530640924233854L;

  private Integer idOperacion;

  private String clave;

  private String nombre;


  private ProcesoUnificado proceso;
}
