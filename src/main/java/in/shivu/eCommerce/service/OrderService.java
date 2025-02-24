package in.shivu.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.shivu.eCommerce.model.Order;
import in.shivu.eCommerce.model.User;
import in.shivu.eCommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Order> getUserOrders(User user) {
        List<Order> orders = orderRepository.findByUser(user);
        for (Order order : orders) {
            order.getItems().size(); 
        }
        return orders;
    }

   
    

    public void deleteOrder(Long id, User user) {
        Order order = orderRepository.findByIdAndUser(id, user);
        if (order != null) {
            orderRepository.delete(order);
        }
    }

  
}
