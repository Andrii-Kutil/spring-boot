package springboot.demo.model.mapper;

import org.springframework.stereotype.Component;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.ReviewDto;

@Component
public class ReviewMapper {
    public Review getFullReview(ReviewDto reviewDto, User user, Product product) {
        return Review.builder()
                .helpfulnessDenominator(reviewDto.getHelpfulnessDenominator())
                .helpfulnessNumerator(reviewDto.getHelpfulnessNumerator())
                .score(reviewDto.getScore())
                .summary(reviewDto.getSummary())
                .text(reviewDto.getText())
                .time(reviewDto.getTime())
                .user(user)
                .product(product)
                .build();
    }
}
