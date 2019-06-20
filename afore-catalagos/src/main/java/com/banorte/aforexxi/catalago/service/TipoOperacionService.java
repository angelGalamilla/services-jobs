package com.banorte.aforexxi.catalago.service;

import java.util.List;
import com.banorte.aforexxi.catalago.dto.TipoOperacionDTO;

public interface TipoOperacionService {

  public List<TipoOperacionDTO> getAllTipoOperacion();

  public List<TipoOperacionDTO> getTipoOperacionByIdTramite(Integer idTramite);
}
