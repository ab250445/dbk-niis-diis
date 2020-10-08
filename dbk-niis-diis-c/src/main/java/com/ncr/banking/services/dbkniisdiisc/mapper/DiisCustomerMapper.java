package com.ncr.banking.services.dbkniisdiisc.mapper;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.intuit.ifs.afeLibrary.broker.diis.type.ServiceType;
import com.intuit.ifs.afeLibrary.util.dto.DiId;
import com.ncr.banking.services.dbkniisdiis.api.model.HostId;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerPostRequest;
import org.mapstruct.*;

import java.util.List;

//@Component
@Mapper(uses = Message.class, componentModel = "spring")
public  interface DiisCustomerMapper {

    @Mappings({
            @Mapping(target = "REQ",  source = "messageType", qualifiedByName = "mapRequest"),
            @Mapping(target = "USR", source = "request.hostIds", qualifiedByName = "mapUsr"),
            @Mapping(target = "PIN", source = "request.hostIds", qualifiedByName = "mapPin"),
            @Mapping(target = "DINUM", source = "request.institutionId", qualifiedByName = "mapDinum"),
            @Mapping(target = "SERVICE", source = "serviceType", qualifiedByName = "mapService")
     })
    Message customerRequestToDiisMessage(CustomerPostRequest request, String serviceType, MessageType messageType);

    @Named("mapRequest")
    static MessageType mapRequest(MessageType messageType) {
        return messageType;
    }

    @Named("mapDinum")
    static String mapDinum(String src) {
        return (src == null) ? "" : new DiId(src).withPrefix();
    }
    @Named("mapUsr")
    static String mapUsr(List<HostId> hostIds) {

        if (hostIds != null && hostIds.size() > 0 && hostIds.get(0).getValue() != null) {
            return hostIds.get(0).getValue();
        }
        return "";
    }
    @Named("mapPin")
    static String mapPin(List<HostId> hostIds) {
        if (hostIds != null && hostIds.size() > 0  && hostIds.get(0).getPin() != null) {
            return hostIds.get(0).getPin();
        }
        return "";
    }
    @Named("mapService")
    static ServiceType mapService(String src) {
        return ((src != null && src.equals("CASH_MANAGEMENT")) ? ServiceType.BB : ServiceType.IB);
    }
}


