package in.shivu.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import in.shivu.eCommerce.model.Order;
import in.shivu.eCommerce.model.OrderItem;
import in.shivu.eCommerce.model.CartItem;
import in.shivu.eCommerce.model.User;
import in.shivu.eCommerce.service.OrderService;
import in.shivu.eCommerce.service.CartService;

import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;
    
//    @GetMapping("/checkout")
//    public String showCheckoutPage() {
//        return "checkout"; 
//    }


    @PostMapping("/checkout")
    public String checkout(@RequestParam String customerName, @RequestParam String address, @AuthenticationPrincipal User user, Model model) {
        List<CartItem> cartItems = cartService.getAllCartItems();
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setAddress(address);
        order.setStatus("Pending");

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        }

      
        cartService.clearCart();

        model.addAttribute("order", order);
        return "order_confirmation";
    }
}
