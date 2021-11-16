package com.example.homework.service;


import com.example.homework.dao.Evaluation;
import com.example.homework.dto.Speech;
import com.example.homework.services.EvaluationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@Import(EvaluationService.class)
public class EvaluationServiceTest {

    @Autowired
    private EvaluationService evaluationService;

    private List<Speech> speeches = new ArrayList<Speech>();
    private Evaluation evaluation = new Evaluation();

    private void init() {
        this.speeches.add(new Speech("testUser","Internal Security","",45));
        this.speeches.add(new Speech("testUser","Internal Security","",27));
        this.speeches.add(new Speech("testOtherUser","Test","",15));
        this.evaluation.setMostSecurity("testUser");
        this.evaluation.setLeastWordy("testOtherUser");
        this.evaluation.setMostSpeeches("testUser");
    }

    @Test
    public void testEntireEvaluation() {
        this.init();
        Assert.assertEquals(this.evaluation.getLeastWordy(), this.evaluationService.evaluate(this.speeches).getLeastWordy());
        Assert.assertEquals(this.evaluation.getMostSecurity(), this.evaluationService.evaluate(this.speeches).getMostSecurity());
        Assert.assertEquals(this.evaluation.getMostSpeeches(), this.evaluationService.evaluate(this.speeches).getMostSpeeches());
    }
}
