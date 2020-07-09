package springboot.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.Review;
import springboot.demo.model.mapper.ReviewMapper;
import springboot.demo.service.CsvParser;

@Service
public class CsvParserImpl implements CsvParser {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<Review> parseContent(List<String> content) {
        return content.stream()
                .map(l -> reviewMapper.parseLineToReview(l))
                .collect(Collectors.toList());
    }
}
