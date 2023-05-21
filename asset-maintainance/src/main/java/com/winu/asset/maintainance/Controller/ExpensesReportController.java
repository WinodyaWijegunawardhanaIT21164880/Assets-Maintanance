package com.winu.asset.maintainance.Controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winu.asset.maintainance.Model.ExpensesReport;
import com.winu.asset.maintainance.Service.ExpensesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Document
@RestController
@RequestMapping("/expenses-reports")
public class ExpensesReportController {

    @Autowired
    private ExpensesReportService expensesReportService;

    @GetMapping("/{id}")
    public ResponseEntity<ExpensesReport> getExpensesReportById(@PathVariable("id") Long id) {
        ExpensesReport expensesReport = expensesReportService.getExpenseReportById(id);
        return ResponseEntity.ok().body(expensesReport);
    }

    @PostMapping
    public ResponseEntity<ExpensesReport> createExpensesReport(@RequestBody ExpensesReport expensesReport) {
        ExpensesReport createdExpensesReport = expensesReportService.createExpenseReport(expensesReport);
        return ResponseEntity.created(URI.create("/expenses-reports/" + createdExpensesReport.getId())).body(createdExpensesReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpensesReport> updateExpensesReport(@PathVariable("id") Long id, @RequestBody ExpensesReport expensesReport) {
        expensesReport.setId(id);
        ExpensesReport updatedExpensesReport = expensesReportService.updateExpenseReport(expensesReport);
        return ResponseEntity.ok().body(updatedExpensesReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpensesReport(@PathVariable("id") Long id) {
        expensesReportService.deleteExpenseReportById(id);
        return ResponseEntity.noContent().build();
    }
    @JsonBackReference
    @GetMapping
    public ResponseEntity<List<ExpensesReport>> getAllExpensesReports() {
        List<ExpensesReport> expensesReports = expensesReportService.getAllExpenseReports();
        return ResponseEntity.ok().body(expensesReports);
    }
}