package com.charter.dao;

import com.charter.dto.RetailTransaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<RetailTransaction, Long> {
}
