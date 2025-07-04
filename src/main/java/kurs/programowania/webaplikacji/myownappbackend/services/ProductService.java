package kurs.programowania.webaplikacji.myownappbackend.services;

import kurs.programowania.webaplikacji.myownappbackend.models.Product;
import kurs.programowania.webaplikacji.myownappbackend.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(String name, String description, BigDecimal price, boolean forSale, String userId) {
        Product product = new Product(name, description, price, forSale, userId);
        product = productRepository.save(product);
        return product;
    }

    public List<Product> getUserProducts(String userId) {
        return productRepository.findAllByOwnerId(userId);
    }

    public List<Product> getProductsForSale() {
        return productRepository.findAllByForSale(true);
    }

    public void deleteProduct(String productId, String userId) {
        Optional<Product> product = productRepository.findById(productId);

        if(product.isEmpty()) {
            throw new RuntimeException("Product " + productId + " was not found, requested by " + userId);
        }

        if(!product.get().getOwnerId().equals(userId)) {
            throw new RuntimeException("Product " + productId + " does not belong to " + userId);
        }

        productRepository.deleteById(productId);
    }

}
