package com.charter.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "transaction")
public class RetailTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long Id;


    private Double amount;

    private Date date;

    @ManyToMany(mappedBy = "retailTransactionSet",fetch = FetchType.LAZY)
    private Set<Customer> customer;
}
