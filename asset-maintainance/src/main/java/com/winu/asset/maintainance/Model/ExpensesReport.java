package com.winu.asset.maintainance.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document("Expenses Report")
@Data
@NotNull
public class ExpensesReport {
    private List<Purchase> purchase;

    public ExpensesReport(List<Purchase> purchases) {
        this.purchase = purchases;
    }

    private void generateReport() {
        double totalExpenses = 0.0;
        System.out.println("Expenses Report");
        System.out.println("=================");
        System.out.println("Date\tVendor\tInvoice No.\tAmount");
        System.out.println("----------------------------------");

        for (Purchase purchase : purchase) {
            System.out.println(purchase.getPurchaseDate() + "\t" + purchase.getVendor() + "\t" +
                    purchase.getInvoiceNo() + "\t\t" + purchase.getAmount());
            totalExpenses += purchase.getAmount();
        }

        System.out.println("----------------------------------");
        System.out.println("Total Expenses: " + totalExpenses);
    }

    public void setId(Long id) {
    }

    public String getId() {
        return getId();
    }

}

