package com.tunja.market.persistence.crud;

import com.tunja.market.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity,Integer> {

    //Forma tradicional de realizar un query
    //@Query(value = "SELECT  * from productos where id_categoria = ?",nativeQuery = true)

    List<ProductEntity> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<ProductEntity>> findByStockLessThanAndState(int stock,boolean state);

}
