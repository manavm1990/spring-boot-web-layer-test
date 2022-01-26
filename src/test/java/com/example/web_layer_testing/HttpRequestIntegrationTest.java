package com.example.web_layer_testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
    webEnvironment =

        //        Random port avoids conflicts
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestIntegrationTest {

  //  Inject the port
  @LocalServerPort private int port;

  @Autowired private TestRestTemplate trt;

  @Test
  public void shouldReturnGetMessage() throws Exception {
    assertThat(this.trt.getForObject("http://localhost:" + port + "/", String.class))
        .contains("Hello World!");
  }
}
