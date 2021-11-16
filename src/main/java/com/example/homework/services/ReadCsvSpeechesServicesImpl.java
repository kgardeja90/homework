package com.example.homework.services;

import com.example.homework.dto.Speech;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadCsvSpeechesServicesImpl implements ReadCsvService<Speech> {
    @Override
    public List<Speech> readCsv(List<String> paths) {
        return paths.stream().flatMap(path -> this.readSingle(path).stream()).collect(Collectors.toList());
    }

    private List<Speech> readSingle(String path) {
        List<Speech> results = new ArrayList<Speech>();
        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/"+path));

            // create csv bean reader
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Speech.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // cast result
            for (Speech speech : ((Iterable<Speech>) csvToBean)) {
                results.add(speech);
            }

            // close the reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
