package in.shivu.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shivu.eCommerce.model.UserVerification;

@Repository
public interface UserVerificationRepository extends JpaRepository<UserVerification, Long>{
	UserVerification findByToken(String token);
}
