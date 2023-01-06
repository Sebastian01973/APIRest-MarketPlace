package com.tunja.market.persistence;

import com.tunja.market.persistence.crud.ProductCrudRepository;
import com.tunja.market.persistence.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productCrudRepository.findAll();
    }

    public List<ProductEntity> getByCategory(int idCategory){
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<ProductEntity>> getEscasos(int stock){
        return productCrudRepository.findByStockLessThanAndState(stock,true);
    }

    public Optional<ProductEntity> getProductById(int idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public ProductEntity saveProduct(ProductEntity product){
        return productCrudRepository.save(product);
    }

    public void deleteProduct(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }


}
