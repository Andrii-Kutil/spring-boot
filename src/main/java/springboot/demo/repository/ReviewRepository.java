package springboot.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springboot.demo.model.Review;
import springboot.demo.model.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUser(User user);

    @Query("SELECT r.text FROM Review r")
    List<String> findAllText();
}
