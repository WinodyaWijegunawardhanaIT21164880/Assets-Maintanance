package com.winu.asset.maintainance.Repository;


import com.winu.asset.maintainance.Model.ExpensesReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpensesRepository extends MongoRepository<ExpensesReport, Long> {

}
