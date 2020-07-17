package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Review;
import springboot.demo.model.User;

public interface ReviewService {
    Review save(Review review);

    Iterable<Review> saveAll(List<Review> reviews);

    List<Review> findAllByUser(User user);

    List<String> findAllText();
}
