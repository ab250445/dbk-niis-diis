package com.ncr.banking.services.dbkniisdiisc.router;

import com.ncr.banking.services.dbkniisdiisc.constants.ServiceConstants;
import com.ncr.banking.services.dbkniisdiisc.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CustomerRouter {

    /*
     * The router configuration for the Niis-DIIS handler.
     * @param NiisHandler
     * @return
     */

    @Bean
    public RouterFunction<ServerResponse> customerRoutes(CustomerHandler customerHandler){

     return RouterFunctions
             .route(RequestPredicates.GET("/"),
                     customerHandler::monoMessage)
             .andRoute(RequestPredicates.POST("/niis/v1/message/create"), customerHandler::createMessage)
             .andRoute(RequestPredicates.POST("/niis/v1/message"), customerHandler::getMessage)
             .andRoute(RequestPredicates.POST(ServiceConstants.CUSTOMERS_URL), customerHandler::postCustomer);
        // .andRoute(RequestPredicates.GET("/niis/v1/customer"), niisHandler::getCustomer);
    }
}

