package com.ncr.banking.services.dbkniisdiisc.client;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.DiisException;
import com.ncr.banking.services.dbkniisdiisc.config.ConfigProperties;
import com.ncr.banking.services.dbkniisdiisc.model.MessageResponse;
import com.ncr.banking.services.dbkniisdiisc.exception.ApplicationException;
import com.ncr.banking.services.dbkniisdiisc.exception.ServiceException;
import com.ncr.banking.services.dbkniisdiisc.service.ConfigService;
import com.ncr.banking.services.dbkniisdiisc.util.diis.DIISDataSourceCreator;
import com.ncr.banking.services.dbkniisdiisc.util.diis.DiisTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(ConfigProperties.class)
public class DiisClient {

    private static final Logger LOGGER = LogManager.getLogger(DiisClient.class);

    @Autowired
    private DIISDataSourceCreator dataSourceCreator;

    @Autowired
    ConfigService configProperties;

    private DiisTemplate getDiisTemplate(String host, String port) {
        dataSourceCreator.setDefaultHost(host);
        dataSourceCreator.setDefaultPort(Integer.parseInt(port));
        return new DiisTemplate(dataSourceCreator.getDataSource());
    }

    public MessageResponse executeDiis(Message request, String host, String port) {
        final String diisHost = (host == null || host.isEmpty()) ? configProperties.getHost() : host;
        final String diisPort = (port == null || port.isEmpty())   ? configProperties.getPort() : port;
        LOGGER.info("Execute DIis Message host: {} port {}", diisHost, diisPort);

        MessageResponse messageResponse = new MessageResponse();
        try {
            LOGGER.info("getDiisTemplate {}");
            DiisTemplate requestTemplate;
            //requestTemplate = diisTemplateFactory.getDiisTemplate("DI1233", host, port);
            requestTemplate = getDiisTemplate( diisHost, diisPort);

            Message message =  requestTemplate.execute(request);
            LOGGER.info("received response");
            messageResponse.setMessage(message);
        } catch (DiisException diisException) {
            LOGGER.error("A DIIS exception occurred while retrieving {} request.{}", request.getREQ(),diisException.getMessage());
            ServiceException se = new ServiceException(diisException);
            messageResponse.setErrorInfo(se.getErrorInfo());
        } catch (Exception e) {
            LOGGER.error("Error executing DIIS: {}",e.getMessage());
            ApplicationException ae = new ApplicationException(e);
            messageResponse.setErrorInfo(ae.getErrorInfo());
        }
        return messageResponse;
    }

}
