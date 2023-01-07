package com.tunja.market.persistence.mapper;

import com.tunja.market.domain.PurchaseItem;
import com.tunja.market.persistence.entity.ProductBuyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct",target = "productId"),
            @Mapping(source = "amount",target = "quantity"),
            @Mapping(source = "state",target = "active")
    })
    PurchaseItem toPurchaseItem(ProductBuyEntity productBuyEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase",ignore = true),
            @Mapping(target = "product",ignore = true),
            @Mapping(target = "id.idPurchase",ignore = true),
    })
    ProductBuyEntity toProductBuyEntity(PurchaseItem purchaseItem);

}
