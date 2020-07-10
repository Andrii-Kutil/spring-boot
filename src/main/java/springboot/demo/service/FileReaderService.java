package springboot.demo.service;

import java.util.List;
import springboot.demo.model.dto.ReviewDto;

public interface FileReaderService {
    List<ReviewDto> getDataFromCsv(String filePath);
}
