package springboot.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.Role;
import springboot.demo.model.User;
import springboot.demo.service.InjectDataService;
import springboot.demo.service.ProductService;
import springboot.demo.service.ReviewService;
import springboot.demo.service.RoleService;
import springboot.demo.service.UserService;

@Service
public class InjectDataServiceImpl implements InjectDataService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    @Override
    public void injectDataToBase(List<Review> reviews) {
        injectProductsToDataBase(reviews);
        injectRolesToDataBase(createRoles());
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

    @Override
    public Iterable<Role> injectRolesToDataBase(List<Role> roles) {
        return roleService.saveAll(roles);
    }

    @Override
    public List<Role> createRoles() {
        Role userRole = new Role();
        userRole.setName(Role.RoleName.valueOf("USER"));
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.valueOf("ADMIN"));
        return List.of(userRole, adminRole);
    }
}
