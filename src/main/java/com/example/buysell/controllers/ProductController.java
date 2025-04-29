package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor // Automatically generates constructor for final fields
public class ProductController {
    private final ProductService productService; // Handles business logic for products

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title)); // Load and add product list to model
        return "products"; // Render the products view
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id)); // Load product by ID
        return "product-info"; // Render product detail view
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product); // Save new product
        return "redirect:/"; // Redirect to product list
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id); // Delete product by ID
        return "redirect:/"; // Redirect to product list
    }
}
