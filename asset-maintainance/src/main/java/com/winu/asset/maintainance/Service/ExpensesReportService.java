package com.winu.asset.maintainance.Service;

import com.winu.asset.maintainance.Model.ExpensesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesReportService {
    public ExpensesReport getExpenseReportById(Long id) {
        return null;
    }
 @Autowired
    public ExpensesReport createExpenseReport(ExpensesReport expensesReport) {
        return expensesReport;
    }

    public ExpensesReport updateExpenseReport(ExpensesReport expensesReport) {
        return expensesReport;
    }

    public void deleteExpenseReportById(Long id) {
    }

    public List<ExpensesReport> getAllExpenseReports() {
        return null;
    }



}
