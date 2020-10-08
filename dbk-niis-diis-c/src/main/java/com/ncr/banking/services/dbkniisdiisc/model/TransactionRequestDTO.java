package com.ncr.banking.services.dbkniisdiisc.model;

import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.intuit.ifs.afeLibrary.broker.diis.type.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {
   // private List<HostId> hostIds;

    // @JsonProperty("institutionId")
    MessageType messageType;
    private String pin;
    private String user;
    private String institutionId;

    private String accountId;

    @Valid
    @NotEmpty(message = "start date cannot be empty")
    private Date startDate;

    @Valid
    @NotEmpty(message = "enddate cannot be empty")
    private Date endDate;

    private String accountType;
    private String hostIdentifier;
    private String ancillaryKey;
    private String appId;
    private ServiceType serviceType;

}
