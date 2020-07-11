package springboot.demo.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.demo.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
