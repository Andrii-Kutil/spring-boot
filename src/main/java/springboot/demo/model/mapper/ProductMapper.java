package springboot.demo.model.mapper;

import org.springframework.stereotype.Component;
import springboot.demo.model.Product;
import springboot.demo.model.dto.ReviewDto;

@Component
public class ProductMapper {

    public Product getProductFromReviewDto(ReviewDto reviewDto) {
        Product product = new Product();
        product.setId(reviewDto.getProductId());
        return product;
    }
}
