package com.ncr.banking.services.dbkniisdiisc.handler;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


public class NiisHandlerFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest, HandlerFunction<ServerResponse> handlerFunction) {
        if (serverRequest.method().equals(HttpMethod.POST) &&
                !serverRequest.queryParam("action").equals("userVerify") &&
                !serverRequest.queryParam("action").equals("userValidate")) {
            return ServerResponse.status(HttpStatus.FORBIDDEN).build();
        }
        return handlerFunction.handle(serverRequest);
    }

}