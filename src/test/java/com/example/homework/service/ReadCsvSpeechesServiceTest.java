package com.example.homework.service;

import com.example.homework.dto.Speech;
import com.example.homework.services.ReadCsvService;
import com.example.homework.services.ReadCsvSpeechesServicesImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@Import(ReadCsvSpeechesServicesImpl.class)
public class ReadCsvSpeechesServiceTest {

    @Autowired
    private ReadCsvService readCsvService;


    private List<Speech> expected = new ArrayList<Speech>();
    private List<String> paths = new ArrayList<String>();

    private void init() {
        this.expected.add(new Speech("Alexander Abel", "Education Policy", "2012-10-30", 5310));
        this.expected.add(new Speech("Bernhard Belling", "Coal Subsidies", "2012-11-05", 1210));
        this.expected.add(new Speech("Caesare Collins", "Coal Subsidies", "2012-11-06", 1119));
        this.expected.add(new Speech("Alexander Abel", "Internal Security", "2012-12-11", 911));
        this.paths.add("/csvFiles/speeches1.csv");
    }

    @Test
    public void testReadCsv()  {
        this.init();
        List<Speech> actual = new ArrayList<Speech>();
        actual = this.readCsvService.readCsv(this.paths);
        Assert.assertEquals(this.expected.get(1).getWords(), actual.get(1).getWords());
        Assert.assertEquals(this.expected.get(1).getSpeaker(), actual.get(1).getSpeaker());
        Assert.assertEquals(this.expected.get(2).getSpeaker(), actual.get(2).getSpeaker());
        Assert.assertEquals(this.expected.get(2).getTopic(), actual.get(2).getTopic());
        Assert.assertEquals(this.expected.get(3).getSpeaker(), actual.get(3).getSpeaker());
        Assert.assertEquals(this.expected.get(3).getTopic(), actual.get(3).getTopic());
        Assert.assertEquals(this.expected.get(3).getWords(), actual.get(3).getWords());
    }
}
