package com.banorte.xxi.jobServices.service;

import java.util.List;

import com.banorte.xxi.jobServices.dto.ApplicationEntry;

public interface ApplicationService {
	
	public void createApplicationItem(ApplicationEntry request);

    public List<ApplicationEntry> getApplicationItems();

}
