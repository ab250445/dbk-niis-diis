package com.ncr.banking.services.dbkniisdiisc.config;

import com.ncr.banking.services.dbkniisdiisc.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;

@Configuration
@ComponentScan("com.ncr.banking.services.dbkniisdiisc")
@PropertySource("classpath:diis.properties")
@ConfigurationProperties(prefix = "broker.connection")
@EnableConfigurationProperties(ConfigProperties.class)
@Validated
public class ConfigProperties {

    @Autowired
    Environment env;

    @Bean
    public ConfigService configService() {
        ConfigService configService = ConfigService.builder()
                .host(env.getProperty("broker.connection.host"))
                .port(env.getProperty("broker.connection.port"))
                .build();
        return configService;
    }

}