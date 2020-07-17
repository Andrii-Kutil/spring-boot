package springboot.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springboot.demo.model.User;
import springboot.demo.model.dto.UserDto;
import springboot.demo.repository.UserRepository;
import springboot.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<UserDto> findMostActiveUsers(Pageable pageable) {
        return userRepository.findMostActiveUsers(pageable).getContent();
    }
}
