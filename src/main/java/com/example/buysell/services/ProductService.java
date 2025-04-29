package com.example.buysell.services;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    // Injects the ProductRepository to interact with the database
    private final ProductRepository productRepository;

    // Returns a list of products, filtered by title if provided
    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    // Saves a new product and logs the action
    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    // Deletes a product by its ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Retrieves a product by its ID, returns null if not found
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
