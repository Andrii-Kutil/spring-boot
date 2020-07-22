package springboot.demo.model.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.CsvReviewDto;
import springboot.demo.model.dto.ReviewCreateDto;

@Component
public class ReviewMapper {
    public Review getFullReview(CsvReviewDto csvReviewDto, User user, Product product) {
        return Review.builder()
                .helpfulnessDenominator(csvReviewDto.getHelpfulnessDenominator())
                .helpfulnessNumerator(csvReviewDto.getHelpfulnessNumerator())
                .score(csvReviewDto.getScore())
                .summary(csvReviewDto.getSummary())
                .text(csvReviewDto.getText())
                .time(csvReviewDto.getTime())
                .user(user)
                .product(product)
                .build();
    }

    public Review getReviewFromReviewCreateDto(ReviewCreateDto reviewtDto) {
        return Review.builder()
                .helpfulnessNumerator(reviewtDto.getHelpfulnessNumerator())
                .helpfulnessDenominator(reviewtDto.getHelpfulnessDenominator())
                .score(reviewtDto.getScore())
                .summary(reviewtDto.getSummary())
                .text(reviewtDto.getText())
                .time(LocalDateTime.now())
                .build();
    }
}
