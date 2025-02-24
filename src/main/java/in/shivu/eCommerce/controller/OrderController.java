package in.shivu.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.shivu.eCommerce.model.Order;
import in.shivu.eCommerce.model.User;
import in.shivu.eCommerce.service.OrderService;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String viewOrders(Model model, @AuthenticationPrincipal User user) {
        List<Order> orders = orderService.getUserOrders(user);
        model.addAttribute("orders", orders);
        return "orders";
    }



    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id, @AuthenticationPrincipal User user) {
        orderService.deleteOrder(id, user);
        return "redirect:/orders";
    }

  
}
