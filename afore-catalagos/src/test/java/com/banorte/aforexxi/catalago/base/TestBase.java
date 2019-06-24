package com.banorte.aforexxi.catalago.base;

import java.util.Collections;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.banorte.aforexxi.catalago.Application;


/**
 * Created by .
 */


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class,
//    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class TestBase {

//  @Autowired
//  protected TestRestTemplate template;
//
//  @Before
//  public void before() {
//    template.getRestTemplate()
//        .setInterceptors(Collections.singletonList((request, body, execution) -> {
//          request.getHeaders().add("iv-user", "user");
//          return execution.execute(request, body);
//        }));
//  }

}
