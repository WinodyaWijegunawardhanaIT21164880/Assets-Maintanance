package com.winu.asset.maintainance.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document(collection = "assets")
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties
public class Assets {


    @Id
    @MongoId
    @NotNull
    private String id;


    @NotNull
    @Indexed(unique = true)
    private String barcode;

    private String name;

    private String category;

    private String value;

    private String location;

    private String details;

    private String purchaseDate;

    private String purchaseCost;

    private String Vendor;

    private Purchase latestPurchase;

    private boolean disposed;

    public boolean isDisposed() {
        return disposed;
    }

    public void setDisposed(boolean disposed) {
        this.disposed = disposed;
    }

    public String getPurchaseCost() {
        return purchaseCost;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Assets() {
    }

    public Assets(String name, String category, double value, String location, String details,
                  LocalDate purchaseDate, Purchase latestPurchase, String purchaseCost, String vendor) {
        this.name = name;
        this.category = category;
        this.value = String.valueOf(value);
        this.location = location;
        this.details = details;
        this.purchaseDate = String.valueOf(purchaseDate);
        this.latestPurchase = latestPurchase;
        this.purchaseCost = purchaseCost;
        this.Vendor = vendor;
        this.barcode = getBarcode();
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = String.format("%.2f", value);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = String.valueOf(purchaseDate);
    }

    public Purchase getLatestPurchase() {
        return latestPurchase;
    }

    public void setLatestPurchase(Purchase latestPurchase) {
        this.latestPurchase = latestPurchase;
    }
}

