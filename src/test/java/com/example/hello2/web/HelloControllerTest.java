package com.example.hello2.web;


import com.example.hello2.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void hello_실행하기() {
        //given
        String test = "책의 내용을 이해하기 위하여 만들 작업";

        //when
//        helloController.hello();

        //then
        assertThat(test).isEqualTo(helloController.hello());
    }
}
