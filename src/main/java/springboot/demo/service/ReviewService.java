package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Review;

public interface ReviewService {
    Review save(Review review);

    Iterable<Review> saveAll(List<Review> reviews);
}
