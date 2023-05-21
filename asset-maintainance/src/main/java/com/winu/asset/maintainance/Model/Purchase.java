package com.winu.asset.maintainance.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Purchase")
@Data
@NotNull

public class Purchase {
    private String assetId;
    private LocalDate purchaseDate;
    private String vendor;
    private String invoiceNo;

    public Purchase(String assetId, LocalDate purchaseDate, String vendor, String invoiceNo) {
        this.assetId = assetId;
        this.purchaseDate = purchaseDate;
        this.vendor = vendor;
        this.invoiceNo = invoiceNo;
    }

    public Purchase(String assetId) {
        this.assetId = assetId;
    }

    public Purchase(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public double getAmount() {
        return getAmount();
    }
}
