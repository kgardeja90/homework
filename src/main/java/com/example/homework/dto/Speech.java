package com.example.homework.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Speech {
    @CsvBindByName
    private String speaker;
    @CsvBindByName
    private String topic;
    @CsvBindByName
    private String date;
    @CsvBindByName
    private int words;
}
