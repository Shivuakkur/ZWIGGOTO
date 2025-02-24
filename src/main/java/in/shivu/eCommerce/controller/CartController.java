package in.shivu.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import in.shivu.eCommerce.model.CartItem;
import in.shivu.eCommerce.service.CartService;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartService.getAllCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addCartItem(@RequestParam Long productId) {
        cartService.addCartItem(productId);
        return "redirect:/cart";
    }

    
}
