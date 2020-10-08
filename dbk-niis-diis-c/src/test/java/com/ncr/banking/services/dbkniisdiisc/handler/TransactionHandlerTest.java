package com.ncr.banking.services.dbkniisdiisc.handler;

import com.ncr.banking.services.dbkniisdiisc.config.ConfigProperties;
import com.ncr.banking.services.dbkniisdiisc.mapper.TransactionRequestMapper;
import com.ncr.banking.services.dbkniisdiisc.mock.MockConstants;
import com.ncr.banking.services.dbkniisdiisc.util.diis.DiisTemplate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


import static org.mockito.Mockito.when;

@AutoConfigureWebTestClient
@SpringBootTest
@TestPropertySource("/diis-test.properties")
@EnableConfigurationProperties(value = ConfigProperties.class)
@ContextConfiguration(classes = ConfigProperties.class)
class TransactionHandlerTest {

    static final Logger logger = LoggerFactory.getLogger(CustomerHandlerTest.class.getName());

    @Autowired
    private static TransactionRequestMapper transactionRequestMapper;

    @MockBean
    private DiisTemplate diisTemplate;


    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ConfigProperties configProperties;


    @BeforeAll
    public static void init() {
        transactionRequestMapper = Mappers.getMapper(TransactionRequestMapper.class);
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
     }

    @Test
    @Disabled
    public void testMonoEndpoint() {
        Flux<String> msg$ = webTestClient.get()
                .uri("/niis/v1/transactions/test")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .returnResult(String.class).getResponseBody()
                .log();
        StepVerifier.create(msg$)
                .expectNext(MockConstants.TEST_MESSAGE)
                .verifyComplete();

    }


}