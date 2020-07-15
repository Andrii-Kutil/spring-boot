package springboot.demo.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import springboot.demo.model.User;
import springboot.demo.model.dto.UserDto;

public interface UserService {
    User save(User user);

    Iterable<User> saveAll(List<User> users);

    List<UserDto> findMostActiveUsers(Pageable pageable);
}
