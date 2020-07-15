package springboot.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springboot.demo.model.Product;
import springboot.demo.model.dto.ProductDto;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT new springboot.demo.model.dto.ProductDto(p.id, COUNT(r.product.id)) "
            + "FROM Product p JOIN Review r ON p.id = r.product.id GROUP BY "
            + "r.product ORDER BY COUNT(r.product) DESC")
    Page<ProductDto> findMostCommentedProducts(Pageable pageable);
}
