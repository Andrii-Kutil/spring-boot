package springboot.demo.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.CsvReviewDto;
import springboot.demo.model.mapper.ProductMapper;
import springboot.demo.model.mapper.ReviewMapper;
import springboot.demo.model.mapper.UserMapper;
import springboot.demo.service.CsvReader;
import springboot.demo.util.ParseMillisecondsToLocalDateTime;

@Service
public class CsvReaderImpl implements CsvReader {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Review> getDataFromCsv(String fileName) {
        List<Review> reviews = new ArrayList<>();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:" + fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found. " + e);
        }

        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(file
                .getAbsoluteFile()), CsvPreference.STANDARD_PREFERENCE)) {
            String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            CsvReviewDto csvReviewDto;
            while ((csvReviewDto = beanReader.read(CsvReviewDto.class,
                    headers, processors)) != null) {
                Product product = productMapper.getProductFromReviewDto(csvReviewDto);
                User user = userMapper.getUserFromReviewDto(csvReviewDto);
                reviews.add(reviewMapper.getFullReview(csvReviewDto, user, product));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't parse the file. " + e);
        }
        return reviews;
    }

    private static CellProcessor[] getProcessors() {

        return new CellProcessor[]{
                new ParseLong(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new ParseInt(),
                new ParseInt(),
                new ParseInt(),
                new Optional(new ParseMillisecondsToLocalDateTime()),
                new NotNull(),
                new NotNull()
        };
    }
}
