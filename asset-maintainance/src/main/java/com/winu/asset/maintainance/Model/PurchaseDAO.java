package com.winu.asset.maintainance.Model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

@org.springframework.data.mongodb.core.mapping.Document
@Data
@NotNull
@AllArgsConstructor
public class PurchaseDAO {
    private MongoCollection<Document> assets;

    public PurchaseDAO() {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://Shiksha:shiksha2023@cluster.m3jhco9.mongodb.net/Educational_Management");

        MongoDatabase database = mongoClient.getDatabase("assets");

        MongoCollection<Document> assets = database.getCollection("purchases");
    }

    public void savePurchase(Purchase purchase) {

        Document doc = new Document();
        doc.append("assetId", purchase.getAssetId())
                .append("purchaseDate", purchase.getPurchaseDate())
                .append("vendor", purchase.getVendor())
                .append("invoiceNo", purchase.getInvoiceNo())
                .append("amount", purchase.getAmount());


        MongoCollection<Document> collection = assets;
        collection.insertOne(doc);
    }
}
