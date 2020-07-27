package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.model.dto.ReviewEditDto;

public interface ReviewService {
    Review save(Review review);

    Review save(Review review, User user);

    Iterable<Review> saveAll(List<Review> reviews);

    List<Review> findAllByUser(User user);

    List<String> findAllText();

    void setReviewInfoById(ReviewEditDto reviewEditDto);

    void delete(Long id);

    Review findById(Long id);
}
