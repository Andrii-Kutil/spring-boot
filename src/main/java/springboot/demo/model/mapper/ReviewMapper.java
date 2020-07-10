package springboot.demo.model.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import springboot.demo.model.Review;
import springboot.demo.model.dto.ReviewDto;

@Component
public class ReviewMapper {

    public List<Review> getReviewsFromDto(List<ReviewDto> reviewDtos) {
        return reviewDtos.stream().map(this::getReviewFromDto).collect(Collectors.toList());
    }

    public Review getReviewFromDto(ReviewDto reviewDto) {
        String productId = reviewDto.getProductId();
        String userId = reviewDto.getUserId();
        String profileName = reviewDto.getProfileName();
        int helpfulnessNumerator = Integer.parseInt(reviewDto.getHelpfulnessNumerator());
        int helpfulnessDenominator = Integer.parseInt(reviewDto.getHelpfulnessDenominator());
        int score = Integer.parseInt(reviewDto.getScore());
        LocalDateTime time = getLocalDateTimeFromString(reviewDto.getTime());
        String summary = reviewDto.getSummary();
        String text = reviewDto.getText();
        Review build = Review.builder().productId(productId).userId(userId)
                .profileName(profileName).helpfulnessNumerator(helpfulnessNumerator)
                .helpfulnessDenominator(helpfulnessDenominator)
                .score(score).time(time).summary(summary).text(text).build();
        return build;
    }

    LocalDateTime getLocalDateTimeFromString(String time) {
        long milliseconds = Long.parseLong(time);
        return LocalDateTime
                .ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault());
    }
}
