package in.shivu.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.shivu.eCommerce.model.OTP;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {
    OTP findByOtp(String otp);
}
