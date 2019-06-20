package com.banorte.aforexxi.catalago.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banorte.aforexxi.catalago.dto.ProcesoUnificadoDTO;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;
import com.banorte.aforexxi.catalago.repository.ProcesoUnificadoRepository;
import com.banorte.aforexxi.catalago.service.ProcesoUnificadoService;

@Service
public class ProcesoUnificadoServiceImpl implements ProcesoUnificadoService {

  @Autowired
  private ProcesoUnificadoRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<ProcesoUnificadoDTO> getAllProcesoUnificado() {
    List<ProcesoUnificadoDTO> listaProcesoUnificado = repository.findAll().stream()
        .map(proceso -> modelMapper.map(proceso, ProcesoUnificadoDTO.class))
        .collect(Collectors.toList());

    if (listaProcesoUnificado == null || listaProcesoUnificado.isEmpty()) {
      throw new BusinessException(1);
    }
    return listaProcesoUnificado;
  }

  @Override
  public ProcesoUnificadoDTO getProcesoUnificadoById(Integer idProceso) {
    ProcesoUnificadoDTO procesoUnificado = null;
    Optional<ProcesoUnificado> proceso = repository.findById(idProceso);

    if (proceso.isPresent()) {
      procesoUnificado = modelMapper.map(proceso.get(), ProcesoUnificadoDTO.class);
    } else {
      throw new BusinessException(1);
    }

    return procesoUnificado;
  }

}
