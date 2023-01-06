package com.tunja.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categorias")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private Boolean state;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}
