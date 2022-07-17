package repository;

import models.CategoryProduct;
import models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Long> {
    Optional<CategoryProduct> findProductCategoryById(Long id);
}
