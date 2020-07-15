package springboot.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.model.dto.ProductDto;
import springboot.demo.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/most-commented-products")
    public List<ProductDto> findMostCommentedProduct(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return productService.findMostCommentedProducts(pageable);
    }
}
