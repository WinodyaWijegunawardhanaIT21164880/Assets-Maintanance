package com.winu.asset.maintainance.Repository;

import com.winu.asset.maintainance.Model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}

