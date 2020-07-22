package springboot.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springboot.demo.model.Product;
import springboot.demo.model.dto.ProductDto;
import springboot.demo.repository.ProductRepository;
import springboot.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public List<ProductDto> findMostCommentedProducts(Pageable pageable) {
        return productRepository.findMostCommentedProducts(pageable).getContent();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found for this id:" + id));
    }
}
