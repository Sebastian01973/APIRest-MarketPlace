package com.tunja.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_compra", insertable = false,updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto",insertable = false,updatable = false)
    private ProductEntity product;

}
