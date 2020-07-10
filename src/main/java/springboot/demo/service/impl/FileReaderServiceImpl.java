package springboot.demo.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Service;
import springboot.demo.model.dto.ReviewDto;
import springboot.demo.service.FileReaderService;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    public List<ReviewDto> getDataFromCsv(String filePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ReviewDto.class)
                    .withIgnoreQuotations(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + e);
        }
    }
}
