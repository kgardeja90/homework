package com.example.homework.controller;

import com.example.homework.dao.Evaluation;
import com.example.homework.facades.EvaluationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EvaluationController {

    private final EvaluationFacade Evaluator;

    @Autowired
    public EvaluationController(EvaluationFacade evaluator) {
        Evaluator = evaluator;
    }

    @GetMapping("/evaluation")
    Evaluation evaluate(@RequestParam List<String> url) {
        if (url == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "you have to at least pass one url");
        }
        try {
            return Evaluator.evaluate(url);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "one of the urls was not found", ex);
        }
    }
}
