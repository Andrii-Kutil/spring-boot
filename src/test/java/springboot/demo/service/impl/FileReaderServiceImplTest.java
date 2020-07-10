package springboot.demo.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import springboot.demo.model.dto.ReviewDto;
import java.io.IOException;
import java.util.List;

class FileReaderServiceImplTest {
    FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
    List<ReviewDto> dataFromCsv;

    @Test
    public void getDataFromCsvOk() throws IOException {
        dataFromCsv = fileReaderService.getDataFromCsv("C:\\Users\\PC\\IdeaProjects" +
                "\\amazon\\src\\main\\resources\\test-reviews.csv");
        Assert.assertEquals(3, dataFromCsv.size());
    }
}