package com.ncr.banking.services.dbkniisdiisc.util.diis;

import com.intuit.ifs.afeLibrary.broker.BrokerException;
import com.intuit.ifs.afeLibrary.broker.diis.DiisClient;
import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.DiisErrorList;
import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.DiisException;
import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.spring.DiisDataSource;
import com.intuit.ifs.afeLibrary.util.exception.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//import org.slf4j.ext.XLogger;
//import org.slf4j.ext.XLoggerFactory;
//import org.slf4j.profiler.StopWatch;

public class DiisTemplate {
    static final Logger logger = LoggerFactory.getLogger(DiisTemplate.class.getName());

    DiisDataSource dataSource = null;

    public DiisDataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DiisDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DiisTemplate() {
    }

    public DiisTemplate(DiisDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Message execute(Message request) {
        Instant start = Instant.now();
      /*  StopWatch watch = null;
        if (Logger.isDebugEnabled()) {
            watch = new StopWatch("DIIS:execute");
            watch.start("DIIS:execute");
        }

       */

        logger.debug("Starting DIIS Request Call:{}", request.getREQ());
        List responses = null;

        try {
            responses = this.execute(Arrays.asList(request));
        } finally {
            if (logger.isDebugEnabled()) {
                //watch.stop();

                logger.debug("Finished execution of DIIS Request:{} in time:{} milliseconds", request.getREQ(), Duration.between(start, Instant.now()).toMillis());
            } else {
                logger.debug("Finished execution of DIIS Request:{}", request.getREQ());
            }
        }
        return responses != null && responses.size() != 0 ? (Message) responses.get(0) : null;
    }

    public List<Message> execute(List<Message> requests) {
        //logger.entry(new Object[]{requests});
        if (this.dataSource == null) {
            throw new IllegalStateException("DataSource is not configured for DIIS template");
        } else if (this.dataSource.getHost() == null) {
            throw new IllegalStateException("DataSource host is not configured for DIIS template");
        } else if (this.dataSource.getPort() == 0) {
            throw new IllegalStateException("DataSource port is not configured for DIIS template");
        } else {
            DiisClient client = new DiisClient();
            client.setHost(this.dataSource.getHost());
            client.setPort(this.dataSource.getPort());
            if (this.dataSource.getReconnects() != 0) {
                client.setReconnects(this.dataSource.getReconnects());
            }

            if (this.dataSource.getTimeout() != 0) {
                client.setTimeout(this.dataSource.getTimeout());
            }

            List response;
            DiisException se;
            try {
                response = client.process(requests);
            } catch (AsynchronousCloseException var8) {
               // logger.catching(var8);
                 se = new DiisException(var8, "Broker call timed out", "21901", ErrorInfo.ErrorType.APP_ERROR, DiisErrorList.getInstance().getErrorMessage("21901"));
                throw se;
            } catch (IOException var9) {
                //LOGGER.catching(var9);
                se = new DiisException(var9, "DIIS Access IO Error", "21999", ErrorInfo.ErrorType.APP_ERROR, DiisErrorList.getInstance().getErrorMessage("21999"));
                throw se;
            } catch (BrokerException var10) {
                //LOGGER.catching(var10);
                throw var10;
            } catch (RuntimeException var11) {
                //LOGGER.catching(var11);
                se = new DiisException(var11, "DIIS Access", "21999", ErrorInfo.ErrorType.APP_ERROR, DiisErrorList.getInstance().getErrorMessage("21999"));
                throw se;
            }

            if (response != null && !response.isEmpty()) {
                Iterator var12 = response.iterator();

                while(var12.hasNext()) {
                    Message message = (Message)var12.next();
                    this.processMessageRC(message);
                }
            }
            return response;
        }
    }

    private void processMessageRC(Message message) {
        Long returnValue = message.getRC();
        String warnMessage = message.getWARN();
        String errorMessage = message.getERRMSG();
        String errorCode = null;
        MessageType responseMessageType = message.getRSP();
        if (warnMessage != null && !warnMessage.isEmpty()) {
            logger.warn("Received warning message from DIIS Response for Message {} --> {}", responseMessageType, warnMessage);
        }

        if (returnValue != null && returnValue.intValue() == 10) {
            logger.warn("The return code is 10, which means 'Success, but no balances are available'");
        }

        if ((MessageType.USRVER.equals(responseMessageType) || MessageType.USRVERSUM.equals(responseMessageType)) && returnValue != null && returnValue.intValue() == 5) {
            logger.warn("The return code is 5, which means 'Success, but user must change pin'");
        }

        if (returnValue != null && returnValue.intValue() != 0 && returnValue.intValue() != 10 && (!MessageType.USRVER.equals(responseMessageType) || returnValue.intValue() != 5)) {
            String responseMessageTypeString = responseMessageType != null ? responseMessageType.toString() : null;
            logger.error("Received non-successful RC: {} in DIIS Response for Message Type {}. Throwing Exception", returnValue, responseMessageType);
            errorCode = DiisErrorList.getInstance().getErrorCodeForDIISRC(responseMessageTypeString, returnValue.toString());
            ErrorInfo.ErrorType errorType = DiisErrorList.getInstance().getErrorTypeForErrorCode(errorCode);
            DiisException se = new DiisException(responseMessageTypeString, errorCode, errorType, DiisErrorList.getInstance().getErrorMessage(errorCode), new Object[][]{{"RC", returnValue}, {"ERRMSG", errorMessage}});
            throw se;
        }
    }
}
