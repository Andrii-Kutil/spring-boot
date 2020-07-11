package springboot.demo.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import springboot.demo.model.Review;
import springboot.demo.service.CsvReader;
import springboot.demo.util.ParseMillisecondsToLocalDateTime;

@Service
public class CsvReaderImpl implements CsvReader {

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
            Review review;
            while ((review = beanReader.read(Review.class, headers, processors)) != null) {
                reviews.add(review);
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
