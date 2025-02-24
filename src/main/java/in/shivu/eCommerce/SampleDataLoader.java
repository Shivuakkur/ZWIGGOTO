package in.shivu.eCommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import in.shivu.eCommerce.model.Product;
import in.shivu.eCommerce.repository.ProductRepository;

@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Apples", "Kashmir apples.", 399, "/images/apples.jpg"));
        productRepository.save(new Product("Bananas", "Sweet bananas.", 49, "/images/bananas.jpg"));
        productRepository.save(new Product(" Milk", "Fresh  milk.", 99, "/images/milk.jpg"));
        productRepository.save(new Product("Brown Bread", "Healthy brown bread.", 99, "/images/bread.jpg"));
        productRepository.save(new Product("Eggs", "Fresh eggs.", 69, "/images/eggs.jpg"));
        productRepository.save(new Product("Orange Juice", "Freshly squeezed orange juice.", 49, "/images/orange_juice.jpg"));
       
      
        productRepository.save(new Product("Chicken", "Boneless, skinless chicken.", 399, "/images/chicken_breast.jpg"));
        productRepository.save(new Product("Salmon Fish", "Fresh salmon fish.", 1299, "/images/salmon_fillet.jpg"));
        
        productRepository.save(new Product("Carrots", "sweet carrots.", 199, "/images/carrots.jpg"));
        
        productRepository.save(new Product("Tomatoes", "Juicy tomatoes.", 89, "/images/tomatoes.jpg"));
        productRepository.save(new Product("Potatoes", "Fresh potatoes.", 99, "/images/potatoes.jpg"));
        productRepository.save(new Product("Onions", "Fresh onions.", 79, "/images/onions.jpg"));
        productRepository.save(new Product("Garlic", "Fresh garlic.", 149, "/images/garlic.jpg"));
  
        productRepository.save(new Product("Cucumbers", "Fresh cucumbers.", 39, "/images/cucumbers.jpg"));

        productRepository.save(new Product("Strawberries", "Sweet and juicy strawberries.", 499, "/images/strawberries.jpg"));
 
        productRepository.save(new Product("Grapes", "Sweet and juicy grapes.", 299, "/images/grapes.jpg"));
        productRepository.save(new Product("Watermelon", "Refreshing watermelon.", 79, "/images/watermelon.jpg"));
        productRepository.save(new Product("Pineapple", "Fresh pineapple.", 99, "/images/pineapple.jpg"));
        productRepository.save(new Product("Mangoes", "Sweet mangoes.", 99, "/images/mangoes.jpg"));

    }
}
