package springboot.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.Review;
import springboot.demo.model.User;
import springboot.demo.repository.ReviewRepository;
import springboot.demo.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

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
}
