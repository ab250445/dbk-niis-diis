package com.ncr.banking.services.dbkniisdiisc.handler;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerPostRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerResponse;
import com.ncr.banking.services.dbkniisdiisc.model.MessageResponse;
import com.ncr.banking.services.dbkniisdiisc.repository.CustomerDiisRepository;
import com.ncr.banking.services.dbkniisdiisc.util.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class CustomerHandler {
    static final Logger logger = LoggerFactory.getLogger(CustomerHandler.class.getName());

    @Autowired
    private CustomerDiisRepository customerDiisRepository;

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> monoMessage(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(
                        Mono.just("UP"), String.class
                );
    }

    public CustomerRequest createCustomerRequest(CustomerPostRequest body, final ServerRequest serverRequest) {
        logger.debug("createCustomerRequest");
        HttpHeaders headers = serverRequest.headers().asHttpHeaders();
        return new CustomerRequest(body,
                headers.getFirst("broker-host"),
                headers.getFirst("broker-port"),
                headers.getFirst("serviceType"),
                serverRequest.queryParam("action").orElse(""));
    }

    public CustomerResponse handlerError() {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode("DSCN_9999");
        errorInfo.setMessage("Action not supported");
        return new CustomerResponse();
    }

    public Mono<ServerResponse> createMessage(ServerRequest serverRequest) {
        logger.debug("handle createMessage");


        /*Mono.just(0)
                .filter(condition -> condition != 1)
                .switchIfEmpty(Mono.just(1));

         */
     /*   Mono<CustomerResponse> result = serverRequest.bodyToMono(CustomerPostRequest.class)
                .map(body -> createCustomerRequest(body, serverRequest))
                .log()
                //.filter(request -> request.getAction().equals("userVerify"))
                //.switchIfEmpty(this::handlerError)
                //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic())
                .flatMap(customerDiisRepository::verifyCustomer);

        return customerToServerResponse(result); */

        Mono<Message> result = serverRequest.bodyToMono(CustomerPostRequest.class)
                .map(body -> createCustomerRequest(body, serverRequest))
                .log()
                //.filter(request -> request.getAction().equals("userVerify"))
                //.switchIfEmpty(this::handlerError)
                //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic())
                .flatMap(customerDiisRepository::createMessage);
        return ServerResponse.ok()
                 //.contentType(MediaType.TEXT_PLAIN)
                .body(result, Message.class);

    }

    public Mono<ServerResponse> getMessage(ServerRequest serverRequest) {
        logger.debug("handle getMessage");

        Mono<MessageResponse> result = serverRequest.bodyToMono(CustomerPostRequest.class)
                .map(body -> createCustomerRequest(body, serverRequest))
                .log()
                //.filter(request -> request.getAction().equals("userVerify"))
                //.switchIfEmpty(this::handlerError)
                //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic())
                .flatMap(customerDiisRepository::getMessage);
        return ServerResponse.ok()
                // .contentType(MediaType.TEXT_PLAIN)
                .body(result, MessageResponse.class);
    }


    // USRVER
    public Mono<ServerResponse> postCustomer(ServerRequest serverRequest) {
        logger.debug("handle postCustomer");


        /*Mono.just(0)
                .filter(condition -> condition != 1)
                .switchIfEmpty(Mono.just(1));

         */
        Mono<CustomerResponse> result = serverRequest.bodyToMono(CustomerPostRequest.class)
                .map(body -> createCustomerRequest(body, serverRequest))
                .log()
                //.filter(request -> request.getAction().equals("userVerify"))
                //.switchIfEmpty(this::handlerError)
                //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic());
                .flatMap(customerDiisRepository::verifyCustomer);

        return customerToServerResponse(result);
    }
/*
    // USRINFO
    public Mono<ServerResponse> getCustomer(ServerRequest serverRequest) {
        logger.debug("handle getCustomer");

        Mono<CustomerResponse> result = serverRequest.bodyToMono(CustomerPostRequest.class)
                .map(body -> createCustomerRequest(body, serverRequest))
                .flatMap(customerDiisRepository::getCustomer);

        return customerToServerResponse(result);

    }
*/
    Mono<ServerResponse> customerToServerResponse(Mono<CustomerResponse> result) {
        return result.flatMap(data -> {
            if (data.getCustomer() != null) {

                return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .header("tmhost", data.getHeaders().getFirst("tmhost"))
                        .bodyValue(data.getCustomer());
            } else {
                return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(data.getErrorInfo());
            }
        }).onErrorResume(error -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
