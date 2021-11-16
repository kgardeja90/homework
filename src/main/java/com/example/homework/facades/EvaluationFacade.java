package com.example.homework.facades;

import com.example.homework.dao.Evaluation;
import com.example.homework.services.EvaluationService;
import com.example.homework.services.ReadCsvSpeechesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

@Component
public class EvaluationFacade {

    private final ReadCsvSpeechesServicesImpl csvService;
    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationFacade(ReadCsvSpeechesServicesImpl csvService, EvaluationService evaluationService) {
        this.csvService = csvService;
        this.evaluationService = evaluationService;
    }

    public Evaluation evaluate(List<String> paths) {
        return this.evaluationService.evaluate(this.csvService.readCsv(paths));
    }
}
