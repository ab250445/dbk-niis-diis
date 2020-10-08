/*
 * CONFIDENTIAL -- Copyright 2017 Digital Insight. This material contains certain *
 * trade secrets and confidential and proprietary information of Digital Insight. *
 * Use, reproduction, disclosure and distribution by any means are prohibited,*
 * except pursuant to a written license from Digital Insight. Use of copyright *
 * notice is precautionary and does not imply publication or disclosure. *
 */
package com.ncr.banking.services.dbkniisdiisc.util.diis;

import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.spring.DiisDataSource;
import com.intuit.ifs.afeLibrary.util.dto.RequestContext;
import com.intuit.ifs.afeLibrary.util.exception.CommonErrorList;
import com.intuit.ifs.afeLibrary.util.exception.ConfigurationException;
import com.intuit.ifs.afeLibrary.util.exception.ErrorInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * DIIS Data source factory that creates datasource to the DIIS broker.
 * <p>
 * <p>
 *     // to do - implement ConfigService
 */
@Component
public class DIISDataSourceCreator {


    private String defaultBroker;
    private String defaultHost;
    private int defaultPort;
    private int defaultTimeout;
    private int defaultReconnects;

    public String getDefaultBroker() {
        return this.defaultBroker;
    }

    public void setDefaultBroker(String defaultBroker) {
        this.defaultBroker = defaultBroker;
    }

    public String getDefaultHost() {
        return this.defaultHost;
    }

    public void setDefaultHost(String defaultHost) {
        this.defaultHost = defaultHost;
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    public void setDefaultPort(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    public int getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public void setDefaultTimeout(int defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
    }

    public int getDefaultReconnects() {
        return this.defaultReconnects;
    }

    public void setDefaultReconnects(int defaultReconnects) {
        this.defaultReconnects = defaultReconnects;
    }

    public DiisDataSource getDataSource() {
        DiisDataSource dataSource;

        // To do: Check CAPS for FI level//
        String host = defaultHost;
        int port = defaultPort;
        int timeout = defaultTimeout;
        int reconnects = defaultReconnects;

        if (StringUtils.isBlank(host)) {
            ConfigurationException ce = new ConfigurationException("Broker host: Configuration cannot be empty",
                    CommonErrorList.CODE_CONFIGURATION, ErrorInfo.ErrorType.APP_ERROR,
                    CommonErrorList.getInstance().getErrorMessage(CommonErrorList.CODE_CONFIGURATION),
                    new Object[][]{{"institutionId", RequestContext.getBcId()}});
            throw ce;
        }

        if (port == 0) {

            ConfigurationException ce = new ConfigurationException("Broker port: Configuration cannot be empty or 0",
                    CommonErrorList.CODE_CONFIGURATION, ErrorInfo.ErrorType.APP_ERROR,
                    CommonErrorList.getInstance().getErrorMessage(CommonErrorList.CODE_CONFIGURATION),
                    new Object[][]{{"institutionId", RequestContext.getBcId()}});

            throw ce;
        }

        dataSource = new DiisDataSource(host, port);

        if (timeout > 0) {
            dataSource.setTimeout(timeout);
        }

        if (reconnects > 0) {
            dataSource.setReconnects(reconnects);
        }

        return dataSource;
    }
}