package com.ncr.banking.services.dbkniisdiisc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private CustomerPostRequest customerPostRequest;
    private String host;
    private String port;
    private String serviceType;
    private String action;

}
