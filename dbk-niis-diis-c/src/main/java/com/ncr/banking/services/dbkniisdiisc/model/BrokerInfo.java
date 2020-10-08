package com.ncr.banking.services.dbkniisdiisc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrokerInfo {
    String brokerHost;
    String brokerPort;
}
