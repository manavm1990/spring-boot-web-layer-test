package com.example.web_layer_testing;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.web_layer_testing.home.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// Only web layer - not whole context, and only the 1️⃣ controller
@WebMvcTest(HomeController.class)
public class WebApplicationMockTest {

//  Mock 🤡 - no actual server
  @Autowired private MockMvc mock;

  @Test
  public void shouldReturnGetMessage() throws Exception {

    this.mock
        .perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World!")));
  }
}
