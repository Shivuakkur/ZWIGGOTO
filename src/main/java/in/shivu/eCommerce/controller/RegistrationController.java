package in.shivu.eCommerce.controller;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.shivu.eCommerce.model.User;
import in.shivu.eCommerce.service.EmailService;
import in.shivu.eCommerce.service.UserService;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
    	System.out.println(user);
        if (userService.saveUser(user)) {
            String otp = generateOTP();
            userService.saveOTP(user, otp);

            // Send OTP to user's email without including the token, if you want you can include token but you need to verify in the database (it may causes login error so i removed the token)
            emailService.sendOTP(user.getUsername(), "Email OTP Verification", otp);

            // Redirect to OTP verification page with token as a parameter(mainly verify otp)
            model.addAttribute("user", user);
            return "redirect:/verify-otp?token=" + UUID.randomUUID().toString();
        } else {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
    }

    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
