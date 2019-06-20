package com.banorte.aforexxi.catalago.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banorte.aforexxi.catalago.dto.TramiteDTO;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.model.SubProceso;
import com.banorte.aforexxi.catalago.repository.TramiteRepository;
import com.banorte.aforexxi.catalago.service.TramiteService;

@Service
public class TramiteServiceImpl implements TramiteService {

  @Autowired
  private TramiteRepository tramiteRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<TramiteDTO> getAllTramite() {
    List<TramiteDTO> listaTramite = tramiteRepository.findAll().stream()
        .map(tramite -> modelMapper.map(tramite, TramiteDTO.class)).collect(Collectors.toList());

    if (listaTramite == null || listaTramite.isEmpty()) {
      throw new BusinessException(1);
    }
    return listaTramite;
  }

  @Override
  public List<TramiteDTO> getTramiteByIdSubProcess(Integer idSubProceso) {
    SubProceso subProceso = SubProceso.builder().idSubProceso(idSubProceso).build();

    List<TramiteDTO> listaTramite = tramiteRepository.findBySubproceso(subProceso).stream()
        .map(tramite -> modelMapper.map(tramite, TramiteDTO.class)).collect(Collectors.toList());

    if (listaTramite == null || listaTramite.isEmpty()) {
      throw new BusinessException(1);
    }
    return listaTramite;
  }

}
