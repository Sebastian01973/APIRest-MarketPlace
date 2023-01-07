package com.tunja.market.persistence;

import com.tunja.market.domain.Purchase;
import com.tunja.market.domain.repository.IPurchaseRepository;
import com.tunja.market.persistence.crud.PurchaseCrudRepository;
import com.tunja.market.persistence.entity.ProductEntity;
import com.tunja.market.persistence.entity.PurchaseEntity;
import com.tunja.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public List<Purchase> getAll() {
        List<PurchaseEntity> purchases = (List<PurchaseEntity>) purchaseCrudRepository.findAll();
        return purchaseMapper.toPurchases( purchases);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> purchaseMapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchasesEntity(purchase);
        System.out.println("El problema es aca...");

        purchaseEntity.getProducts().forEach(product -> product.setPurchase(purchaseEntity));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }

}
