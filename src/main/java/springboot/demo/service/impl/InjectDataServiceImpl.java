package springboot.demo.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.Role;
import springboot.demo.model.User;
import springboot.demo.repository.UserRepository;
import springboot.demo.service.InjectDataService;
import springboot.demo.service.ProductService;
import springboot.demo.service.ReviewService;
import springboot.demo.service.UserService;

@Service
public class InjectDataServiceImpl implements InjectDataService {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;

    @Override
    public void injectDataToBase(List<Review> reviews) {
        injectUser();
        injectAdmin();
        injectProductsToDataBase(reviews);
        injectUsersToDataBase(reviews);
        injectReviewsToDataBase(reviews);
    }

    @Override
    public Iterable<Review> injectReviewsToDataBase(List<Review> reviews) {
        return reviewService.saveAll(reviews);
    }

    @Override
    public Iterable<Product> injectProductsToDataBase(List<Review> reviews) {
        List<Product> products = reviews.stream().map(Review::getProduct)
                .collect(Collectors.toList());
        return productService.saveAll(products);
    }

    @Override
    public Iterable<User> injectUsersToDataBase(List<Review> reviews) {
        List<User> users = reviews.stream().map(Review::getUser).collect(Collectors.toList());
        return userService.saveAll(users);
    }

    public User injectAdmin() {
        User admin = User.builder()
                .email("admin@admin.com")
                .password(cryptPasswordEncoder.encode("1234"))
                .profileName("admin")
                .roles(Set.of(new Role("ROLE_ADMIN")))
                .build();
        return userRepository.save(admin);
    }

    public User injectUser() {
        User user = User.builder()
                .email("user@user.com")
                .password(cryptPasswordEncoder.encode("1234"))
                .profileName("user")
                .roles(Set.of(new Role("ROLE_USER")))
                .build();
        return userRepository.save(user);
    }
}
