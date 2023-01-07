package com.tunja.market.persistence.mapper;

import com.tunja.market.domain.Purchase;
import com.tunja.market.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase",target = "purchaseId"),
            @Mapping(source = "idClient",target = "clientId"),
            @Mapping(source = "halfPayment",target = "paymentMethod"),
    })
    Purchase toPurchase(PurchaseEntity purchaseEntity);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntity);

    @InheritInverseConfiguration
    @Mapping(target = "client",ignore = true)
    PurchaseEntity toPurchasesEntity(Purchase purchase);
}
