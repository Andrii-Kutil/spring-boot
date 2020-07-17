package springboot.demo.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import springboot.demo.model.Product;
import springboot.demo.model.dto.ProductDto;

public interface ProductService {
    Product save(Product product);

    Iterable<Product> saveAll(List<Product> products);

    List<ProductDto> findMostCommentedProducts(Pageable pageable);
}
