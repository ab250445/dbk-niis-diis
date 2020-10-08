package com.ncr.banking.services.dbkniisdiisc.handler;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.ncr.banking.services.dbkniisdiis.api.model.Transaction;
import com.ncr.banking.services.dbkniisdiisc.model.*;
import com.ncr.banking.services.dbkniisdiisc.repository.TransactionsRepository;
import com.ncr.banking.services.dbkniisdiisc.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class TransactionsHandler {
    static final Logger logger = LoggerFactory.getLogger(TransactionsHandler.class.getName());


    private final TransactionsRepository transactionsRepository;

    public TransactionsHandler(TransactionsRepository repository) {
        this.transactionsRepository= repository;
    }

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public TransactionRequestDTO createTransactionRequest(final ServerRequest serverRequest) {
        logger.debug("createTransactionRequest");
        HttpHeaders headers = serverRequest.headers().asHttpHeaders();
        MultiValueMap<String, String> params = serverRequest.queryParams();

        BrokerInfo brokerInfo = BrokerInfo.builder()
                .brokerHost(headers.getFirst("broker-host"))
                .brokerPort( headers.getFirst("broker-port"))
                .build();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);

        Date startDate = null;
        Date endDate = null;

        try {
            String date = params.getFirst("startDate");
            startDate = formatter.parse(date);

            date = params.getFirst("endDate");
            endDate = formatter.parse(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        TransactionRequestDTO transactionRequestDTO = TransactionRequestDTO.builder()
                .messageType(MessageType.ACTHST)
                .institutionId( headers.getFirst("institutionId"))
                .user(params.getFirst("customerId"))
                .accountId(params.getFirst("accountId"))
                .accountType(params.getFirst("accountType"))
                .hostIdentifier(params.getFirst("hostIdentifier"))
                .ancillaryKey((headers.getFirst("ancillaryKey")))
                .startDate(startDate)
                .endDate(endDate)
                .serviceType(CommonUtil.convertServiceType(headers.getFirst("serviceType")))
                .institutionId(CommonUtil.convertInstitutionId(headers.getFirst("institutionId")))
                .appId(headers.getFirst("appId"))
                .build();
        return transactionRequestDTO;
      }


    public Mono<ServerResponse> monoMessage(ServerRequest request) {
        return ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(
                        Mono.just("UP"), String.class
                );
    }

    public Mono<ServerResponse> createMessage(ServerRequest serverRequest) {
        Mono<Message> result = Mono.just(serverRequest)
                .map(this::createTransactionRequest)
                .log()
                  //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic())
                .flatMap(transactionsRepository::createMessage);
        return ServerResponse.ok()
                //.contentType(MediaType.TEXT_PLAIN)
                .body(result, Message.class);
    }

    public Mono<ServerResponse> getTransactions(ServerRequest serverRequest) {
        HttpHeaders headers = serverRequest.headers().asHttpHeaders();
        final String tmhost = "";

        BrokerInfo brokerInfo = BrokerInfo.builder()
                .brokerHost(headers.getFirst("broker-host"))
                .brokerPort( headers.getFirst("broker-port"))
                .build();
        Mono<List<Transaction>> result = Mono.just(serverRequest)
                .map(this::createTransactionRequest)
                .log()
                //.flatMap(user -> Mono.fromRunnable(() -> customerDiisRepository.verifyCustomer(user))
                //      .subscribeOn(Schedulers.elastic())
                .flatMap(request -> transactionsRepository.getTransactions(request, brokerInfo))
              //  .map(tuples -> tmhost = tuples.getT2().getFirst("tmhost"))
                .map(Tuple3::getT1);

      return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(result, Transaction.class);
    }

}
