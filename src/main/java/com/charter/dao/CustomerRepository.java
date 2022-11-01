package com.charter.dao;

import com.charter.dto.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {



}