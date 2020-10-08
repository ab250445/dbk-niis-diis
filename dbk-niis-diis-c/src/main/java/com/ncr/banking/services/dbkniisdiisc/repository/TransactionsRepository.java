package com.ncr.banking.services.dbkniisdiisc.repository;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.ncr.banking.services.dbkniisdiis.api.mapper.TransactionMapper;
import com.ncr.banking.services.dbkniisdiis.api.model.Transaction;
import com.ncr.banking.services.dbkniisdiisc.client.DiisClient;
import com.ncr.banking.services.dbkniisdiisc.model.*;
import com.ncr.banking.services.dbkniisdiisc.exception.ServiceException;
import com.ncr.banking.services.dbkniisdiisc.mapper.TransactionRequestMapper;
import com.ncr.banking.services.dbkniisdiisc.util.ErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionsRepository {
    private static final Logger LOGGER = LogManager.getLogger(TransactionsRepository.class);

    @Autowired
    DiisClient diisClient;

    @Autowired
    private TransactionRequestMapper transactionRequestMapper;

    //private CustomerMapper customerMapper;

    public TransactionsRepository() {
         LOGGER.info("get TransactionRequestMapper");
     }

    public Mono<Message> createMessage(TransactionRequestDTO transactionRequestDTO) {
        LOGGER.debug("TransactionRequest [{}]", transactionRequestDTO.toString());

        Message message = transactionRequestMapper.transactionRequestToACTHST(
                transactionRequestDTO);
        LOGGER.info("Created Message {}", message.getREQ());
        return Mono.just(message);

    }
    public Mono<Tuple3<List<Transaction>, HttpHeaders,ErrorInfo>> getTransactions(TransactionRequestDTO transactionRequestDTO, BrokerInfo brokerInfo) {
        LOGGER.debug("Sending DIIS ACTHST to client host");


        return Mono.just(transactionRequestMapper.transactionRequestToACTHST(
                transactionRequestDTO))
                .map(request -> diisClient.executeDiis(request, brokerInfo.getBrokerHost(), brokerInfo.getBrokerPort()))
                .onErrorMap(original -> new ServiceException(original))
                .checkpoint("executed diis request")
                .flatMap(this::convertDiisResponseToTransaction);

    }

    public Mono<Tuple3<List<Transaction>, HttpHeaders,ErrorInfo>> convertDiisResponseToTransaction(MessageResponse response) {

        LOGGER.info("Converting DIIS ACTHST Response to Transaction object");
        List<Transaction> transactions = new ArrayList<Transaction>();
        ErrorInfo errorInfo = new ErrorInfo();
        HttpHeaders headers = new HttpHeaders();

        if(response.getMessage() != null) {
            LOGGER.debug("Map DIIS response");
            transactions = TransactionMapper.mapDiisMessage(response.getMessage());

            headers.add("tmhost", String.valueOf(response.getMessage().getTMHOST()));


          /*  try this to add tmhost to header
          String key = "message";
            Mono<String> r = Mono.just("Hello")
                    .flatMap( s -> Mono.subscriberContext()
                            .map( ctx -> s + " " + ctx.get(key)))
                    .subscriberContext(ctx -> ctx.put(key, "World"));
            */
        }
        else {
           errorInfo = response.getErrorInfo();
        }
        return Mono.zip(Mono.just(transactions), Mono.just(headers), Mono.just(errorInfo));

    }

}
