package com.banorte.aforexxi.catalago.controller;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SubProcesoControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  private static final String URI = "/catServices/getSubProcesos";

  private HttpEntity<Object> entity;


  @Before
  public void initData() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("Content-Type", "application/json");

    this.entity = new HttpEntity<>(null, headers);

  }

  @Test
  public void debeRetornarOK() {

    ResponseEntity<List<SubProcesoDTO>> response = restTemplate.exchange(URI + "/4", HttpMethod.GET,
        this.entity, new ParameterizedTypeReference<List<SubProcesoDTO>>() {});

    assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void debeObtenerTodaListaProcesos() {
    ResponseEntity<List<SubProcesoDTO>> response = restTemplate.exchange(URI, HttpMethod.GET,
        this.entity, new ParameterizedTypeReference<List<SubProcesoDTO>>() {});

    assertEquals(200, response.getStatusCodeValue());
  }

}
