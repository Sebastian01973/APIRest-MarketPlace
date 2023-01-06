package com.tunja.market.persistence;

import com.tunja.market.domain.Product;
import com.tunja.market.domain.repository.IProductRepository;
import com.tunja.market.persistence.crud.ProductCrudRepository;
import com.tunja.market.persistence.entity.ProductEntity;
import com.tunja.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> products = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<ProductEntity>> products = productCrudRepository.findByStockLessThanAndState(quantity,true);
        return products.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<ProductEntity> productEntity = productCrudRepository.findById(productId);
        return productEntity.map(prods -> productMapper.toProduct(prods));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
