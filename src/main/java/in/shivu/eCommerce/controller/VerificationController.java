package in.shivu.eCommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.shivu.eCommerce.model.OTP;
import in.shivu.eCommerce.service.UserService;

@Controller
public class VerificationController {
    private static final Logger logger = LoggerFactory.getLogger(VerificationController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/verify-otp")
    public String showOTPVerificationForm(Model model) {
        logger.debug("Showing OTP verification form");
        model.addAttribute("otp", new OTP());
        return "verify-otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestParam String otp, Model model) {
        logger.debug("Verifying OTP: {}", otp);

        if (userService.verifyOTP(otp)) {
            logger.debug("OTP verified successfully.");
            model.addAttribute("message", "Email verified successfully. You can now log in.");
            return "login";
        } else {
            logger.debug("Invalid OTP.");
            model.addAttribute("error", "Invalid OTP");
            return "verify-otp";
        }
    }
}
