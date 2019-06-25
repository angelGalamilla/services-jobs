/*
* (C)Copyright 2019, Afore XXI Banorte S.A. de C.V.
*
* Este archivo contiene información que es exclusivo de Afore XXI Banorte y 
* se considera confidencial. Esta estrictamente prohibido copiar o 
* compartir de manera total o parcial en cualquier formato, 
* ya sea mecánico o electrónico.
*
* Nombre de archivo: ApplicationService.java
* Autor: hfriasga
* Fecha de creación: 25/06/2019
*/

package com.banorte.xxi.jobServices.service;

import org.springframework.web.multipart.MultipartFile;
import com.banorte.xxi.jobServices.dto.ApplicationEntry;

/**
 * The Interface ApplicationService.
 */
public interface ApplicationService {
	    
    /**
     * Store file.
     *
     * @param file the file
     * @param applicationEntry the application entry
     * @return true, if successful
     */
    public boolean storeFile(MultipartFile file, ApplicationEntry applicationEntry);

}
