package springboot.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.ReviewEditDto;
import springboot.demo.repository.ReviewRepository;
import springboot.demo.service.ReviewService;
import springboot.demo.service.UserService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private UserService userService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review review, User user) {
        review.setUser(user);
        return reviewRepository.save(review);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Iterable<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public List<Review> findAllByUser(User user) {
        return reviewRepository.findAllByUser(user);
    }

    @Override
    public List<String> findAllText() {
        return reviewRepository.findAllText();
    }

    @Override
    public void setReviewInfoById(ReviewEditDto reviewEditDto) {
        reviewRepository.setReviewInfoById(reviewEditDto.getHelpfulnessNumerator(),
                reviewEditDto.getHelpfulnessDenominator(),
                reviewEditDto.getScore(), reviewEditDto.getSummary(),
                reviewEditDto.getText(), reviewEditDto.getId());
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found for this id:" + id));
    }
}
