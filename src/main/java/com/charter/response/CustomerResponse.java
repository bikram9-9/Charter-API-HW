package com.charter.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String firstName;
    private String lastName;
    private Long points;

    private void CustomerReponse(String firstName, String lastName, Long points){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.points = points;
    }

}
