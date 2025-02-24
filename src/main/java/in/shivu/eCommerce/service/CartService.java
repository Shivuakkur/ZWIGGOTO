package in.shivu.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.shivu.eCommerce.model.CartItem;
import in.shivu.eCommerce.model.Product;
import in.shivu.eCommerce.repository.CartRepository;
import in.shivu.eCommerce.repository.ProductRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }

    public void addCartItem(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1); // Default quantity to 1
            cartRepository.save(cartItem);
        }
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }
}
