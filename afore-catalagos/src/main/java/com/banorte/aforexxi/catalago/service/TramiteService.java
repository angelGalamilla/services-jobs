package com.banorte.aforexxi.catalago.service;

import java.util.List;
import com.banorte.aforexxi.catalago.dto.TramiteDTO;

public interface TramiteService {

  public List<TramiteDTO> getAllTramite();

  public List<TramiteDTO> getTramiteByIdSubProcess(Integer idSubProceso);
}
