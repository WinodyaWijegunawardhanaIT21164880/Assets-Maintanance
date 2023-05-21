package com.winu.asset.maintainance.Controller;

import com.winu.asset.maintainance.Model.Purchase;
import com.winu.asset.maintainance.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class purchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/save")
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable("id") Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @PostMapping("/save")
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(@PathVariable("id") Long id, @RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(id, purchase);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deletePurchase(id);
    }
}
