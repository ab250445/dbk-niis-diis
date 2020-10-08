package com.ncr.banking.services.dbkniisdiisc.router;

import com.ncr.banking.services.dbkniisdiisc.constants.ServiceConstants;
import com.ncr.banking.services.dbkniisdiisc.handler.TransactionsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.reactive.function.server.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TransactionRouter {

    @Bean
    public RouterFunction<ServerResponse> transactionRoutes(TransactionsHandler transactionsHandler) {
        return RouterFunctions.route(RequestPredicates.GET(ServiceConstants.TRANSACTION_URL)
                .and(accept(APPLICATION_JSON)), transactionsHandler::getTransactions)
                .andRoute(RequestPredicates.GET("/niis/v1/transactions/test")
                        .and(accept(APPLICATION_JSON)), transactionsHandler::monoMessage)
               .andRoute(RequestPredicates.GET("/niis/v1/transactions/create")
                .and(accept(APPLICATION_JSON)), transactionsHandler::createMessage);

    }
}
