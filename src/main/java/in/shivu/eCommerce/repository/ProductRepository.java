package in.shivu.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.shivu.eCommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
