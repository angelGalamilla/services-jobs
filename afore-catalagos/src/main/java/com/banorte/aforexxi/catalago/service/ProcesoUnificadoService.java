package com.banorte.aforexxi.catalago.service;

import java.util.List;
import com.banorte.aforexxi.catalago.dto.ProcesoUnificadoDTO;

public interface ProcesoUnificadoService {

  public List<ProcesoUnificadoDTO> getAllProcesoUnificado();

  public ProcesoUnificadoDTO getProcesoUnificadoById(Integer idProceso);
}
