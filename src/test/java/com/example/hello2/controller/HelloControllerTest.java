package com.example.hello2.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_실행하기() {
        //given
        String test = "책의 내용을 이해하기 위하여 만들 작업";

        //when
//        helloController.hello();

        //then
        assertThat(test).isEqualTo(helloController.hello());
    }

    @Test
    public void stock_가져오기() throws Exception {
        //given

        //when

        //then
        mvc.perform(get("/list"))
                .andExpect(status().isOk());

    }
}
