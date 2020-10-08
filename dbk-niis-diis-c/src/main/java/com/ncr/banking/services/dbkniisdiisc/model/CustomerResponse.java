package com.ncr.banking.services.dbkniisdiisc.model;

import com.ncr.banking.services.dbkniisdiis.api.model.Customer;
import com.ncr.banking.services.dbkniisdiisc.util.ErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Customer customer;
    private HttpHeaders headers;
    private ErrorInfo errorInfo;
}
