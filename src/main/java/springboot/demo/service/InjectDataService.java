package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Product;
import springboot.demo.model.Review;
import springboot.demo.model.Role;
import springboot.demo.model.User;

public interface InjectDataService {
    void injectDataToBase(List<Review> reviews);

    Iterable<Review> injectReviewsToDataBase(List<Review> reviews);

    Iterable<Product> injectProductsToDataBase(List<Review> reviews);

    Iterable<User> injectUsersToDataBase(List<Review> reviews);

    Iterable<Role> injectRolesToDataBase(List<Role> roles);

    List<Role> createRoles();
}
