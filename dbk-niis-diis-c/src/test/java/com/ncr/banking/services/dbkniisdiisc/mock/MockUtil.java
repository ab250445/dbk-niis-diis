package com.ncr.banking.services.dbkniisdiisc.mock;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.intuit.ifs.afeLibrary.broker.diis.type.ServiceType;
import com.intuit.ifs.afeLibrary.util.dto.DiId;
import com.ncr.banking.services.dbkniisdiis.api.model.Customer;
import com.ncr.banking.services.dbkniisdiis.api.model.HostId;
import com.ncr.banking.services.dbkniisdiis.api.model.Person;

import com.ncr.banking.services.dbkniisdiisc.model.CustomerPostRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {

    public static List<HostId> createHostIdList() {
        HostId hostId = HostId.builder()
                .type(HostId.TypeEnum.MEMBER_ID)
                .pin(MockConstants.PIN)
                .value(MockConstants.HOSTID)
                .build();
        List<HostId> hostIds = new ArrayList<HostId>();
        hostIds.add(hostId);
        return hostIds;
    }

    public static  CustomerPostRequest createCustomerPostRequest() {
        CustomerPostRequest customerPostRequest = CustomerPostRequest.builder()
                .hostIds(createHostIdList())
                .institutionId(MockConstants.INSTITUTION_ID)
                .build();

        return customerPostRequest;
    }

    public static CustomerRequest createCustomerRequest() {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .customerPostRequest(createCustomerPostRequest())
                .serviceType( (ServiceType.IB).getDescription())
                .build();
        return customerRequest;
    }

    public static CustomerResponse createCustomerResponse() {
        // mock customer response
        Customer customer = Customer.builder()
                .id("1")
                .institutionId(MockConstants.INSTITUTION_ID)
                .person( Person.builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .fullName("Jane Doe")
                        .build())
                .hostIds(createHostIdList())
                .build();

        CustomerResponse customerResp = CustomerResponse.builder()
                .customer(customer)
                .build();
        return customerResp;
    }

    public static Message createMessageResponse(String hostid, MessageType messageType) {
        Message message = new Message();

        message.setDIID( new DiId(MockConstants.INSTITUTION_ID).withPrefix());
        message.setUSR(hostid);
        message.setRC(0L);
        message.setRSP(messageType);

        return message;
    }

    public static Message createMessageRequest(MessageType messageType) {
        Message message = new Message();

        message.setDIID( new DiId(MockConstants.INSTITUTION_ID).withPrefix());
        message.setUSR(MockConstants.HOSTID);
        message.setREQ(messageType);

        return message;
    }
}
