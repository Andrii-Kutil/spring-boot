package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Review;

public interface CsvReader {
    List<Review> getDataFromCsv(String fileName);
}
