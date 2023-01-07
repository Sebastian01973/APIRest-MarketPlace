package com.tunja.market.domain.repository;

import com.tunja.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
