package com.tunja.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "compras_productos")
public class ProductBuyEntity {

    @EmbeddedId
    private ProductBuyPK id;

    @Column(name = "cantidad")
    private Integer amount;

    private Double total;

    @Column(name = "estado")
    private Boolean state;
}
