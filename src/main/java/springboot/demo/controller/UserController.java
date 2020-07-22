package springboot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.model.User;
import springboot.demo.model.dto.UserDto;
import springboot.demo.model.dto.UserRegistrationDto;
import springboot.demo.model.mapper.UserMapper;
import springboot.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/most-active-users")
    public List<UserDto> findMostActiveUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return userService.findMostActiveUsers(pageable);
    }

    @PostMapping("/registration")
    public User registerUserAccount(@RequestBody UserRegistrationDto userDto) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            throw new RuntimeException("There is already an account registered with that email"
                    + user.getEmail());
        }
        return userService.save(userMapper.getUserFromRegistrationDto(userDto));
    }
}
