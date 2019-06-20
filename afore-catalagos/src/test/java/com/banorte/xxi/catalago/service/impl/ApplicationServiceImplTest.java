package com.banorte.xxi.catalago.service.impl;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.banorte.aforexxi.catalago.dto.SubProcesoDTO;
import com.banorte.aforexxi.catalago.service.ApplicationService;

@RunWith(SpringRunner.class)
// @DataJpaTest
public class ApplicationServiceImplTest {

  // @Autowired
  // private TestEntityManager entityManager;
  //
  // @Autowired
  // private ApplicationRepository repository;

  @Autowired
  private ApplicationService applicationService;

  @Test
  public void givenAllSubProcesoServiceTest() {
    List<SubProcesoDTO> listSubProceso = applicationService.getAllSubProcesos();
    assertNotNull(listSubProceso);
  }
}
