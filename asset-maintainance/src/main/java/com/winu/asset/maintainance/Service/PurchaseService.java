package com.winu.asset.maintainance.Service;

import com.winu.asset.maintainance.Model.Purchase;
import com.winu.asset.maintainance.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private PurchaseRepository purchaseRepo;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public void savePurchase(Purchase purchase) {
        purchaseRepo.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return null;
    }

    public Purchase getPurchaseById(Long id) {
        return null;
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchase;
    }

    public Purchase updatePurchase(Long id, Purchase purchase) {
        return purchase;
    }

    public Purchase deletePurchase(Long id) {
        return null;
    }
}
