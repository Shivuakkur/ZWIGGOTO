package in.shivu.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.shivu.eCommerce.model.SavedCart;

import java.util.List;

public interface SavedCartRepository extends JpaRepository<SavedCart, Long> {
    List<SavedCart> findByUserId(Long userId);
}
