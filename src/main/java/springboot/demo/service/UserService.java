package springboot.demo.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import springboot.demo.model.User;
import springboot.demo.model.dto.UserDto;

public interface UserService extends UserDetailsService {

    Iterable<User> saveAll(List<User> users);

    List<UserDto> findMostActiveUsers(Pageable pageable);

    User findByEmail(String email);

    User save(User user);
}
