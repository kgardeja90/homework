package com.example.homework;

import com.example.homework.controller.EvaluationController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeworkApplicationTests {

    @Autowired
    private EvaluationController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
