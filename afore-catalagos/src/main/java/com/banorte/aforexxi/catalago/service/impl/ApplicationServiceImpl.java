package com.banorte.aforexxi.catalago.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;
import com.banorte.aforexxi.catalago.exceptions.BusinessException;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;
import com.banorte.aforexxi.catalago.repository.ApplicationRepository;
import com.banorte.aforexxi.catalago.service.ApplicationService;


/**
 * Created by
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

  private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public List<SubProcesoDTO> getAllSubProcesos() {
    log.info("Get All SubProcesos");
    List<SubProcesoDTO> listSubProceso = applicationRepository.findAll().stream()
        .map(subProceso -> modelMapper.map(subProceso, SubProcesoDTO.class))
        .collect(Collectors.toList());

    if (listSubProceso == null || listSubProceso.isEmpty()) {
      throw new BusinessException(1);
    }
    return listSubProceso;
  }

  @Override
  public List<SubProcesoDTO> getSubProcesosByIdProcess(Integer idProceso) {
    ProcesoUnificado findProceso = ProcesoUnificado.builder().idProceso(idProceso).build();

    List<SubProcesoDTO> listSubProceso = applicationRepository.findByProceso(findProceso).stream()
        .map(subProceso -> modelMapper.map(subProceso, SubProcesoDTO.class))
        .collect(Collectors.toList());

    if (listSubProceso == null || listSubProceso.isEmpty()) {
      throw new BusinessException(1);
    }

    return listSubProceso;
  }

}
