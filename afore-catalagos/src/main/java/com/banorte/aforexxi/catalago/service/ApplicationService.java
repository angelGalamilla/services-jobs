package com.banorte.aforexxi.catalago.service;

import java.util.List;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;

public interface ApplicationService {

  public List<SubProcesoDTO> getAllSubProcesos();

  public List<SubProcesoDTO> getSubProcesosByIdProcess(Integer idProceso);
}
