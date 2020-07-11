package springboot.demo.service.impl;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import springboot.demo.model.Review;
import springboot.demo.service.CsvReader;

import java.util.List;

class FileReaderServiceImplTest {
    private static final String FILE_NAME = "test-reviews.csv";
    private final CsvReader csvReader = new CsvReaderImpl();

    @Test
    public void getDataFromCsvOk() {
        List<Review> dataFromCsv = csvReader.getDataFromCsv(FILE_NAME);
        dataFromCsv.forEach(System.out::println);
        Assert.assertEquals(4, dataFromCsv.size());
    }
}
