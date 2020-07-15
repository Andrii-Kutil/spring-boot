package springboot.demo.model.mapper;

import org.springframework.stereotype.Component;
import springboot.demo.model.User;
import springboot.demo.model.dto.ReviewDto;

@Component
public class UserMapper {

    public User getUserFromReviewDto(ReviewDto reviewDto) {
        User user = new User();
        user.setUserId(reviewDto.getUserId());
        user.setProfileName(reviewDto.getProfileName());
        return user;
    }
}
