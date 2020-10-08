package com.ncr.banking.services.dbkniisdiisc.mapper;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.ncr.banking.services.dbkniisdiisc.model.TransactionRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = Message.class, componentModel = "spring")
public  interface TransactionRequestMapper {

    @Mappings({
            @Mapping(target = "REQ",  source = "messageType"),
            @Mapping(target = "USR", source = "user"),
            @Mapping(target = "PIN", source = "pin"),
            @Mapping(target = "DINUM", source = "institutionId"),
            @Mapping(target = "SERVICE", source = "serviceType"),
            @Mapping(target = "APPLID", source= "appId"),
            @Mapping(target = "CIF", source = "hostIdentifier"),
            @Mapping(target = "ATYP", source = "accountType"),
            @Mapping(target = "ANUM", source = "accountId"),
            @Mapping(target = "STDT", source = "startDate"),
            @Mapping(target = "HIDDEN", source="ancillaryKey", qualifiedByName = "mapHidden"),
            @Mapping(target = "ENDT", source = "endDate")

     })
    Message transactionRequestToACTHST(TransactionRequestDTO request);

    @Named("mapHidden")
    static List<String> mapHidden(String ancillaryKey) {

        List<String> hiddens = new ArrayList<String>();
        if( (ancillaryKey != null) && (!ancillaryKey.isEmpty()))
        hiddens.add(ancillaryKey);
        return hiddens;
    }


}


