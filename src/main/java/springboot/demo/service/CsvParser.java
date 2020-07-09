package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Review;

public interface CsvParser {
    List<Review> parseContent(List<String> content);
}
