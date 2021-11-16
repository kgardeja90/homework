package com.example.homework.services;

import com.example.homework.dao.Evaluation;
import com.example.homework.dto.Speech;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    public Evaluation evaluate(List<Speech> speeches) {
        Evaluation evaluation = new Evaluation();
        evaluation.setLeastWordy(this.determineLeastWordy(speeches));
        evaluation.setMostSpeeches(this.determineMostSpeeches(speeches));
        evaluation.setMostSecurity(this.determineMostSecurity(speeches));
        return evaluation;
    }

    private String determineLeastWordy(List<Speech> speeches) {
        List<String> speakers = this.getAllSpeakers(speeches);
        Map<String, Integer> speakerWordyMap = new HashMap<String, Integer>();
        for (String speaker : speakers) {
            final int count = speeches.stream().filter(speech -> speech.getSpeaker().equals(speaker)).map(Speech::getWords).mapToInt(Integer::intValue)
                    .sum();
            speakerWordyMap.put(speaker, count);
        }
        return Collections.min(speakerWordyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private String determineMostSecurity(List<Speech> speeches) {
        List<String> speakers = this.getAllSpeakers(speeches);
        Map<String, Integer> speakerSecurityMap = new HashMap<String, Integer>();
        for (String speaker : speakers) {
            final int count = ((int) speeches.stream().filter(speech ->
                    speech.getSpeaker().equals(speaker)).filter(speech ->
                    speech.getTopic().equals("Internal Security")).count());
            speakerSecurityMap.put(speaker, count);
        }
        return Collections.max(speakerSecurityMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private String determineMostSpeeches(List<Speech> speeches) {
        List<String> speakers = this.getAllSpeakers(speeches);
        Map<String, Integer> speakerSpeechesMap = new HashMap<String, Integer>();
        for (String speaker : speakers) {
            final int count = ((int) speeches.stream().filter(speech -> speech.getSpeaker().equals(speaker)).count());
            speakerSpeechesMap.put(speaker, count);
        }
        return Collections.max(speakerSpeechesMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private List<String> getAllSpeakers(List<Speech> speeches) {
        List<String> speakers;
        speakers = speeches.stream().map(Speech::getSpeaker).distinct().collect(Collectors.toList());
        return speakers;
    }
}
