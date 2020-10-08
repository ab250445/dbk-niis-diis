package com.ncr.banking.services.dbkniisdiisc.repository;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.ncr.banking.services.dbkniisdiis.api.mapper.CustomerMapper;
import com.ncr.banking.services.dbkniisdiis.api.model.Customer;
import com.ncr.banking.services.dbkniisdiisc.client.DiisClient;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerResponse;
import com.ncr.banking.services.dbkniisdiisc.model.MessageResponse;
import com.ncr.banking.services.dbkniisdiisc.exception.ServiceException;
import com.ncr.banking.services.dbkniisdiisc.mapper.DiisCustomerMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomerDiisRepository {
    private static final Logger LOGGER = LogManager.getLogger(CustomerDiisRepository.class);

    @Autowired
    DiisClient diisClient;

    // @Autowired
    private static DiisCustomerMapper diisCustomerMapper;

    private CustomerMapper customerMapper;

    public CustomerDiisRepository() {
        customerMapper = new CustomerMapper();
        diisCustomerMapper = Mappers.getMapper(DiisCustomerMapper.class);
    }




   /* public Mono<CustomerResponse> verifyCustomer(CustomerRequest customerRequest) {
        LOGGER.debug("in getCustomer");

        LOGGER.debug("Sending DIIS USRVER to client host");

        return
                Mono.just(diisCustomerMapper.customerRequestToDiisMessage(
                        customerRequest.getCustomerPostRequest(), (customerRequest.getServiceType() == null ? "" : customerRequest.getServiceType()),
                        MessageType.USRVER))
                        .checkpoint("created diis request")
                        .map(request -> executeDiis(request, customerRequest.getHost(), customerRequest.getPort()))
                        //.onErrorMap(original -> new ServiceException(original))
                        .checkpoint("executed diis request")
                        .flatMap(this::convertDiisResponseToCustomer);

    }*/

    public Mono<Message> createMessage(CustomerRequest customerRequest) {
        LOGGER.debug("in getCustomer [{}]",customerRequest.toString());

        Message message = diisCustomerMapper.customerRequestToDiisMessage(
                customerRequest.getCustomerPostRequest(),
                (customerRequest.getServiceType() == null ? "" : customerRequest.getServiceType()),
                MessageType.USRVER);
        LOGGER.info("Created Message {}", message.getREQ());
        return Mono.just(message);


    }
    public Mono<MessageResponse> getMessage(CustomerRequest customerRequest) {
        LOGGER.debug("in getMessage");

        return Mono.just(diisCustomerMapper.customerRequestToDiisMessage(
                customerRequest.getCustomerPostRequest(),
                (customerRequest.getServiceType() == null ? "" : customerRequest.getServiceType()),
                MessageType.USRVER))
                .map(message -> diisClient.executeDiis(message, customerRequest.getHost(), customerRequest.getPort()))
                .onErrorMap(original -> new ServiceException(original));

    }
    public Mono<CustomerResponse> verifyCustomer(CustomerRequest customerRequest) {
        LOGGER.debug("in getCustomer");

        LOGGER.debug("Sending DIIS USRVER to client host");


        return Mono.just(diisCustomerMapper.customerRequestToDiisMessage(
                customerRequest.getCustomerPostRequest(),
                (customerRequest.getServiceType() == null ? "" : customerRequest.getServiceType()),
                MessageType.USRVER))
                .map(request -> diisClient.executeDiis(request, customerRequest.getHost(), customerRequest.getPort()))
                .onErrorMap(original -> new ServiceException(original))
                .checkpoint("executed diis request")
                .flatMap(this::convertDiisResponseToCustomer);

    }

    public Mono<CustomerResponse> convertDiisResponseToCustomer(MessageResponse response) {

        LOGGER.info("Converting DIIS Response to Customer object");

        if(response.getMessage() != null) {
            LOGGER.debug("Map DIIS response");
            Customer customer = customerMapper.mapDiisMessage(response.getMessage());

            HttpHeaders headers = new HttpHeaders();
            headers.add("tmhost", String.valueOf(response.getMessage().getTMHOST()));

            CustomerResponse customerResponse =  new CustomerResponse(customer, headers, null);
            return Mono.just(customerResponse);
        }
        else {
            CustomerResponse customerResponse =  new CustomerResponse(null, null, response.getErrorInfo());
            return Mono.just(customerResponse);
        }

    }
}
