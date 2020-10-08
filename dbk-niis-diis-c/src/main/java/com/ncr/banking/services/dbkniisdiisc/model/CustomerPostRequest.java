package com.ncr.banking.services.dbkniisdiisc.model;


import com.ncr.banking.services.dbkniisdiis.api.model.HostId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPostRequest {

    private List<HostId> hostIds;
    private String institutionId;

}
