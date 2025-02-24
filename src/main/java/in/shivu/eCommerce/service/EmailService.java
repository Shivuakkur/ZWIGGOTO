package in.shivu.eCommerce.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String to, String subject, String body) {
        try {
            validateEmail(to);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to.trim());
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (AddressException e) {
            throw new IllegalArgumentException("Invalid email address: " + to, e);
        }
    }

    public void sendOrderConfirmationEmail(String to, String subject, String body) {
        try {
            validateEmail(to);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to.trim());
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        } catch (AddressException e) {
            throw new IllegalArgumentException("Invalid email address: " + to, e);
        }
    }

    public void sendOTP(String to, String subject, String otp) {
        try {
            validateEmail(to);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to.trim());
            message.setSubject(subject);
            message.setText("Your OTP is: " + otp); // Send only the OTP
            mailSender.send(message);
        } catch (AddressException e) {
            throw new IllegalArgumentException("Invalid email address: " + to, e);
        }
    }

    private void validateEmail(String email) throws AddressException {
        new InternetAddress(email).validate(); // Validate the email address
    }
}
