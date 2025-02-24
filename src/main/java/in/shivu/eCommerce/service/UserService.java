package in.shivu.eCommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.shivu.eCommerce.model.OTP;
import in.shivu.eCommerce.model.User;
import in.shivu.eCommerce.repository.OTPRepository;
import in.shivu.eCommerce.repository.UserRepository;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPRepository otpRepository;

    public void registerUser(User user) {
        userRepository.save(user); // Save password as plain text (not recommended for production or industry level applications , it is okay for testing purpose onlyy)
    }

    public boolean saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void saveOTP(User user, String otp) {
        OTP otpEntity = new OTP(user, otp, null); 
        otpRepository.save(otpEntity);
        logger.debug("Saved OTP for user {}: OTP={}", user.getUsername(), otp);
    }

    public boolean verifyOTP(String otp) {
        logger.debug("Verifying OTP: Entered OTP={}", otp);
        OTP storedOtp = otpRepository.findByOtp(otp);
        if (storedOtp != null) {
            logger.debug("Retrieved OTP from DB: {}", storedOtp.getOtp());
            otpRepository.delete(storedOtp);
            logger.debug("Verified OTP: OTP={}", otp);
            return true;
        } else {
            logger.debug("Failed to verify OTP: Entered OTP={}, No matching OTP found in DB.", otp);
        }
        return false;
    }
}
