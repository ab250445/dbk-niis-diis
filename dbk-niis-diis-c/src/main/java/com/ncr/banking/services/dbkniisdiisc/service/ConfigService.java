package com.ncr.banking.services.dbkniisdiisc.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigService {
    @NotNull
    private String host;

    @NotNull
    private String port;
}
