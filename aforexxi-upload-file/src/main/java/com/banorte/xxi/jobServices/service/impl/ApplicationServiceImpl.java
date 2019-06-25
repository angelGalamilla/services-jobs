/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationServiceImpl.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/
package com.banorte.xxi.jobServices.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.banorte.xxi.jobServices.dto.ApplicationEntry;
import com.banorte.xxi.jobServices.exceptions.StorageException;
import com.banorte.xxi.jobServices.model.ApplicationItem;
import com.banorte.xxi.jobServices.repository.ApplicationRepository;
import com.banorte.xxi.jobServices.service.ApplicationService;

/**
 * The Class ApplicationServiceImpl.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
  
  /** The Constant log. */
  private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);

  /** The application repository. */
  @Autowired
  ApplicationRepository applicationRepository;

  /**
   * Store file.
   *
   * @param file the file
   * @param applicationEntry the application entry
   * @return true, if successful
   */
  @Transactional
  public boolean storeFile(MultipartFile file, ApplicationEntry applicationEntry) {

    ApplicationItem applicationItem =
        ApplicationItem.builder().idNotificacion(applicationEntry.getIdNotificacion())
            .motivo(applicationEntry.getMotivo()).build();
    applicationRepository.save(applicationItem);

    String filename = StringUtils.cleanPath(file.getOriginalFilename());
    try {
      if (file.isEmpty()) {
        throw new StorageException("Fallo al guardar un archivo vacio " + filename);
      }
      if (filename.contains("..")) {
        throw new StorageException(
            "No se pudo guardar el archivo con path relativa a fuera del actual directorio "
                + filename);

      }
      try (InputStream inputStream = file.getInputStream()) {
        Files.copy(inputStream, Paths.get("upload-dir").resolve(filename),
            StandardCopyOption.REPLACE_EXISTING);
      }
    } catch (IOException e) {
      throw new StorageException("Fallo al guardar el archivo " + filename, e);
    }


    return true;
  }

}
