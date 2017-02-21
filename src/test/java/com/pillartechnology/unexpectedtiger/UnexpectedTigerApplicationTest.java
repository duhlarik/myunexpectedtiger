package com.pillartechnology.unexpectedtiger;

import com.pillartechnology.unexpectedtiger.controller.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(IndexController.class)
public class UnexpectedTigerApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexControllerShouldReturnMarkup() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }
}
