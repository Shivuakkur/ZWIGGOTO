package in.shivu.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.shivu.eCommerce.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
