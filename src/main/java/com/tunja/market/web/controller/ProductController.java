package com.tunja.market.web.controller;

import com.tunja.market.domain.Product;
import com.tunja.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

     @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable int productId) {
        return productService.delete(productId);
    }
}
