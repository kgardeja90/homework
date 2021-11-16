package com.example.homework.integration;

import com.example.homework.dao.Evaluation;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EvaluationControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Evaluation expected = new Evaluation("Alexander Abel", "Alexander Abel", "Caesare Collins");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/csvFiles/speeches1.csv",
                Evaluation.class).equals(expected));
    }
}
