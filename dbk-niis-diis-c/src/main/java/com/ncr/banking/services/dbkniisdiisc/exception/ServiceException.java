/*
 * CONFIDENTIAL -- Copyright 2017 Digital Insight. This material contains certain
 *  trade secrets and confidential and proprietary information of Digital Insight.
 *  Use, reproduction, disclosure and distribution by any means are prohibited,
 *  except pursuant to a written license from Digital Insight. Use of copyright
 *  notice is precautionary and does not imply publication or disclosure.
 */

package com.ncr.banking.services.dbkniisdiisc.exception;


import com.intuit.ifs.afeLibrary.dataaccess.dao.diis.DiisException;
import com.ncr.banking.services.dbkniisdiisc.constants.Error;
import com.ncr.banking.services.dbkniisdiisc.constants.ServiceConstants;
import com.ncr.banking.services.dbkniisdiisc.util.CommonUtil;
import com.ncr.banking.services.dbkniisdiisc.util.ErrorInfo;

import org.springframework.http.HttpStatus;

/**
 * Created with IntelliJ IDEA.
 * User: bchou
 * Date: 6/10/14
 * Time: 3:50 PM
 * ServiceException class to hold Durable API Status object for further exception process.
 */
public class ServiceException extends ApplicationException {

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;


    public ServiceException() {
        super();
    }

    public ServiceException(ErrorInfo errorInfo) {
        super();
        this.errorInfo = errorInfo;
    }

    public ServiceException(ErrorInfo errorInfo, HttpStatus status, Throwable cause) {
        this(errorInfo);
        this.initCause(cause);
        this.setHttpStatus(status);
    }

    public ServiceException(Error error) {
        //super(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceException(Error error, Throwable cause) {
        this(error);
        this.initCause(cause);
    }

    public ServiceException(Throwable t, ErrorInfo errorInfo) {
        super(t);
        this.errorInfo = errorInfo;
    }

    public ServiceException(DiisException diisException) {
        this((Throwable) diisException);

        String code, message;
        if (diisException.getErrorList() != null && !diisException.getErrorList().isEmpty()) {
            code = ServiceConstants.DIIS_ERROR_CODE_PREFIX + diisException.getErrorList().get(0).getErrorKey();
            message = diisException.getErrorList().get(0).getErrorMessage();
        } else {
            code = Error.GENERIC_SERVER_ERROR.getCode();
            message = Error.GENERIC_SERVER_ERROR.getMessage();
        }
        this.errorInfo = CommonUtil.createErrorInfo(code, message);
    }

    public ServiceException(Throwable t) {
        super(t);
    }

    /**
     * ServiceException with http status code, errorCode and message
     * @param errorCode
     * @param errorMessage
     * @param httpStatus
     * @param cause
     */
    public ServiceException(String errorCode, String errorMessage, HttpStatus httpStatus, Throwable cause) {
        super(errorCode, errorMessage, httpStatus);
        this.initCause(cause);
        ErrorInfo errorInfo = CommonUtil.createErrorInfo(errorCode, errorMessage);
        this.setErrorInfo(errorInfo);
        this.setHttpStatus(httpStatus);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


}
