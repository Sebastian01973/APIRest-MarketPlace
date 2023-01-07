package com.tunja.market.domain.service;

import com.tunja.market.domain.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private IPurchaseRepository iPurchaseRepository;

}
