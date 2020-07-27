package springboot.demo.model.mapper;

import org.springframework.stereotype.Component;
import springboot.demo.model.User;
import springboot.demo.model.dto.CsvReviewDto;
import springboot.demo.model.dto.UserRegistrationDto;

@Component
public class UserMapper {

    public User getUserFromReviewDto(CsvReviewDto csvReviewDto) {
        return User.builder()
                .userId(csvReviewDto.getUserId())
                .profileName(csvReviewDto.getProfileName())
                .build();
    }

    public User getUserFromRegistrationDto(UserRegistrationDto userRegistrationDto) {
        return User.builder()
                .userId(userRegistrationDto.getUserId())
                .profileName(userRegistrationDto.getProfileName())
                .email(userRegistrationDto.getEmail())
                .password(userRegistrationDto.getPassword())
                .build();
    }
}
