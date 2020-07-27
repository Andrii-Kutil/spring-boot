package springboot.demo.model.mapper;

import org.springframework.stereotype.Component;
import springboot.demo.model.Product;
import springboot.demo.model.dto.CsvReviewDto;

@Component
public class ProductMapper {

    public Product getProductFromReviewDto(CsvReviewDto csvReviewDto) {
        Product product = new Product();
        product.setId(csvReviewDto.getProductId());
        return product;
    }
}
