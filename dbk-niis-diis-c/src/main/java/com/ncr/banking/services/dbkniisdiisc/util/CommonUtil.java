package com.ncr.banking.services.dbkniisdiisc.util;

import com.intuit.ifs.afeLibrary.broker.diis.type.ServiceType;
import com.intuit.ifs.afeLibrary.util.dto.DiId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonUtil {
    private static final Logger LOGGER = LogManager.getLogger(CommonUtil.class);

    /**
     * Helper method to create durable API ErrorInfo for responses to clients.
     * @param code Error code that should be returned to client
     * @param message The status message that should be returned to the client.
     * @return The ErrorInfo object that should be returned to the client.
     */
    public static ErrorInfo createErrorInfo(String code, String message) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(code);
        errorInfo.setMessage(message);
        return errorInfo;
    }

    public static ServiceType convertServiceType(String serviceType) {
        if((serviceType == null) || serviceType.isEmpty())
         return ServiceType.IB;

        if(serviceType.equals("CASH_MANAGEMENT"))
            return ServiceType.BB;
        else
            return ServiceType.IB;
    }

    public static String convertInstitutionId(String institutionId) {
        if(( institutionId != null) && !institutionId.isEmpty())
            return new DiId(institutionId).withPrefix();
        // throw error
        return null;
    }
}
