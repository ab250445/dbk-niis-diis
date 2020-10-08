package com.ncr.banking.services.dbkniisdiisc.mapper;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.intuit.ifs.afeLibrary.broker.diis.type.ServiceType;
import com.intuit.ifs.afeLibrary.util.dto.DiId;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerPostRequest;
import com.ncr.banking.services.dbkniisdiisc.mock.MockConstants;
import com.ncr.banking.services.dbkniisdiisc.mock.MockUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class DiisCustomerMapperTest {


    @Autowired
    private static  DiisCustomerMapper diisCustomerMapper;

    @BeforeEach
    void setUp() {
    }

    @BeforeAll
    public static void init() {
        diisCustomerMapper = Mappers.getMapper(DiisCustomerMapper.class);
    }

    @Test
    void customerRequestToDiisMessage() {
        //----------------
        // USRVER request
        //----------------
        // "REQ"
        // "USR"
        // "PIN"
        // "DINUM"
        // "SERVICE"
        //

        CustomerPostRequest customerPostRequest = MockUtil.createCustomerPostRequest();
        assertThat(customerPostRequest.getInstitutionId()).isEqualTo(MockConstants.INSTITUTION_ID);

        Message message = diisCustomerMapper.customerRequestToDiisMessage(customerPostRequest,
                ServiceType.IB.getDescription(), MessageType.USRVER);

        assertThat( message.getREQ() ).isEqualTo( MessageType.USRVER);
        assertThat( message.getUSR() ).isEqualTo( MockConstants.HOSTID);
        assertThat( message.getDINUM()).isEqualTo(new DiId(MockConstants.INSTITUTION_ID).withPrefix());
        assertThat( message.getSERVICE()).isEqualTo(ServiceType.IB);
        assertThat( message.getPIN()).isEqualTo(MockConstants.PIN);
    }
}