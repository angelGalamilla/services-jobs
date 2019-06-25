
package com.banorte.xxi.jobServices.controller;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;    
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.banorte.xxi.jobServices.dto.ApplicationResponse;

/**
 * The Class ApplicationControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApplicationControllerTest {

  /** The rest template. */
  @Autowired
  private TestRestTemplate restTemplate;

  /** The Constant URI. */
  private static final String URI = "/catServices/carga";

  
  /** The statement. */
  private Statement statement;
  
  /**
   * Crea estructura.
   *
   * @throws SQLException the SQL exception
   */
  @Before
  public void creaEstructura() throws SQLException {
    Connection connection =
        DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "sa", "sa");
    statement = connection.createStatement();

    try {
//      statement.execute("create sequence ESPEVCIFICACION_SEQUENCE");
      statement.execute("create sequence ESPEVCIFICACION_SEQUENCE; "
          + "CREATE TABLE especificacion_archivo ( "
          + "ID_ESPECIFICACION_ARCHIVO NUMBER(5) NOT NULL , "
          + "DESCRIPCION VARCHAR2(255), "
          + "NOMBRE_INICIAL VARCHAR2(255), "
          + "NOMBRE_FINAL VARCHAR2(255), "
          + "CIFRADO VARCHAR2(255), "
          + "CEPARADOR_CAMPO VARCHAR2(1),"
          + "FK_ID_CAT_TIPO_OPERACION NUMBER(5)); ");
                  
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Test
  public void debeLanzarCodigo200() {
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    FileSystemResource file= new FileSystemResource("pom.xml");
    MultiValueMap<String, Object> body
    = new LinkedMultiValueMap<>();
  body.add("file", file);
  body.add("idNotificacion", "1");
  body.add("motivo", "Faltante Archivo");     
  HttpEntity<MultiValueMap<String, Object>> requestEntity
    = new HttpEntity<>(body, headers);
  
    ResponseEntity<ApplicationResponse> response = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, ApplicationResponse.class);

    assertEquals(200, response.getStatusCodeValue());
  }

  @Test
  public void debeLanzarCodigo500() {
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    FileSystemResource file= new FileSystemResource("pom.xml");
    MultiValueMap<String, Object> body
    = new LinkedMultiValueMap<>();
  body.add("file", file);
  body.add("idNotificacion", "e");
  body.add("motivo", "Faltante Archivo");     
  HttpEntity<MultiValueMap<String, Object>> requestEntity
    = new HttpEntity<>(body, headers);
  
    ResponseEntity<ApplicationResponse> response = restTemplate.exchange(URI, HttpMethod.POST, requestEntity, ApplicationResponse.class);

    assertEquals(500, response.getStatusCodeValue());
  }

}
