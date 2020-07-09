package springboot.demo.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import springboot.demo.model.Review;

@Component
public class ReviewMapper {

    public Review parseLineToReview(String line) {
        String[] parameters = line.split(",");
        String productId = parameters[1];
        String userId = parameters[2];
        String profileName = parameters[3];
        int helpfulnessNumerator = Integer.parseInt(parameters[4]);
        int helpfulnessDenominator = Integer.parseInt(parameters[5]);
        int score = Integer.parseInt(parameters[6]);
        LocalDateTime time = convertToLocalDateTime(Long.parseLong(parameters[7]));
        String summary = parameters[8];
        String text = parameters[9];
        return new Review(productId, userId, profileName,
                helpfulnessNumerator, helpfulnessDenominator, score, time, summary, text);
    }

    public LocalDateTime convertToLocalDateTime(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
