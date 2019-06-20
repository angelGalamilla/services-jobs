package com.banorte.xxi.catalago.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;
import com.banorte.aforexxi.catalago.model.ProcesoUnificado;
import com.banorte.aforexxi.catalago.service.ApplicationService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApplicationControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ApplicationService service;

  @Test
  public void givenAllSubProcessTest() throws Exception {

    SubProcesoDTO subProceso = new SubProcesoDTO(1, "1", "Gestión de solicitud de Domiciliación",
        new ProcesoUnificado(1, "P1", "Proceso 1"));


    doReturn(Arrays.asList(subProceso)).when(service).getAllSubProcesos();

    mvc.perform(get("/catServices/getAllSubProcesos").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].nombre", is(subProceso.getNombre())));
  }

  @Test
  public void giveSubProcessByidProcesoTest() throws Exception {

    SubProcesoDTO subProceso =
        new SubProcesoDTO(1, "2", "Alta / Baja", new ProcesoUnificado(1, "P1", "Proceso 1"));


    doReturn(Arrays.asList(subProceso)).when(service).getSubProcesosByIdProcess(1);

    mvc.perform(get("/catServices/getSubProcesos/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$[0].nombre", is(subProceso.getNombre())));
  }

}
