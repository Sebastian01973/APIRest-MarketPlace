package com.tunja.market.domain.service;

import com.tunja.market.domain.Product;
import com.tunja.market.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> getAll(){
        return iProductRepository.getAll();
    }

     public Optional<Product> getProduct(int productId) {
        return iProductRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return iProductRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            iProductRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
