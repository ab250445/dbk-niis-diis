package com.ncr.banking.services.dbkniisdiisc.service;

import com.ncr.banking.services.dbkniisdiisc.config.ConfigProperties;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigProperties.class)
@TestPropertySource("/diis-test.properties")
class ConfigServiceTest {

    @Autowired
    private ConfigService configService;

    @Test
    public void configTest() {
        Assertions.assertThat(configService.getHost()).isEqualTo("brokersim.dev1.diginsite.net");
        Assertions.assertThat(configService.getPort()).isEqualTo("80");

    }
}