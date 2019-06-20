package com.banorte.aforexxi.catalago.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banorte.aforexxi.catalago.dto.TipoOperacionDTO;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.model.Tramite;
import com.banorte.aforexxi.catalago.repository.TipoOperacionRepository;
import com.banorte.aforexxi.catalago.service.TipoOperacionService;

@Service
public class TipoOperacionImpl implements TipoOperacionService {

  @Autowired
  private TipoOperacionRepository tipoOperacionRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<TipoOperacionDTO> getAllTipoOperacion() {
    List<TipoOperacionDTO> listaTipoOperacion = tipoOperacionRepository.findAll().stream()
        .map(tipoOperacion -> modelMapper.map(tipoOperacion, TipoOperacionDTO.class))
        .collect(Collectors.toList());

    if (listaTipoOperacion == null || listaTipoOperacion.isEmpty()) {
      throw new BusinessException(1);
    }

    return listaTipoOperacion;
  }

  @Override
  public List<TipoOperacionDTO> getTipoOperacionByIdTramite(Integer idTramite) {
    Tramite tramite = Tramite.builder().idTramite(idTramite).build();

    List<TipoOperacionDTO> listaTipoOperacion = tipoOperacionRepository.findByTramite(tramite)
        .stream().map(tipoOperacion -> modelMapper.map(tipoOperacion, TipoOperacionDTO.class))
        .collect(Collectors.toList());

    if (listaTipoOperacion == null || listaTipoOperacion.isEmpty()) {
      throw new BusinessException(1);
    }

    return listaTipoOperacion;
  }

}
