package com.charter.dto;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer id;

    private String firstname;

    private String lastName;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "customer_transaction",
            joinColumns = {
                    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false,updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "transaction_id",referencedColumnName = "transaction_id")

            })
    Set<RetailTransaction> retailTransactionSet;
}
