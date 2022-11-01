package com.charter.dao;

import com.charter.dto.Customer;
import com.charter.dto.RetailTransaction;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<RetailTransaction, Long> {
    @Query("SELECT t FROM RetailTransaction t WHERE t.date > ?1")
    List<Transaction> getTransactionsAfter(Date date);
}
