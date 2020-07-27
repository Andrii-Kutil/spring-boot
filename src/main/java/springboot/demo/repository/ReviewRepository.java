package springboot.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.model.Review;
import springboot.demo.model.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUser(User user);

    @Query("SELECT r.text FROM Review r")
    List<String> findAllText();

    @Modifying
    @Transactional
    @Query("update Review r set r.helpfulnessNumerator = ?1, r.helpfulnessDenominator = ?2,"
            + "r.score = ?3, r.summary = ?4, r.text = ?5 where r.id = ?6")
    void setReviewInfoById(Integer helpfulnessNumerator, Integer helpfulnessDenominator,
                           Integer score, String summary, String text, Long id);
}
