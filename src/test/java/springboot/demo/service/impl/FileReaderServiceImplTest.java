package springboot.demo.service.impl;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import springboot.demo.model.dto.ReviewDto;

import java.util.List;

class FileReaderServiceImplTest {
    private static final String FILE_NAME = "test-reviews.csv";
    private final FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();

    @Test
    public void getDataFromCsvOk() {
        List<ReviewDto> dataFromCsv = fileReaderService.getDataFromCsv(FILE_NAME);
        Assert.assertEquals(3, dataFromCsv.size());
    }
}
