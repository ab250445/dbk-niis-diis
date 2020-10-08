/*
 * CONFIDENTIAL -- Copyright 2017 Digital Insight. This material contains certain
 *  trade secrets and confidential and proprietary information of Digital Insight.
 *  Use, reproduction, disclosure and distribution by any means are prohibited,
 *  except pursuant to a written license from Digital Insight. Use of copyright
 *  notice is precautionary and does not imply publication or disclosure.
 */

package com.ncr.banking.services.dbkniisdiisc.exception;

import com.ncr.banking.services.dbkniisdiisc.util.ErrorInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

/**
 * Created by sk250573 on 10/25/17.
 */
public class ApplicationException extends RuntimeException {

    protected ErrorInfo errorInfo;
    protected HttpStatus httpStatus;

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable t) {
        super(t);
    }

    /*public ApplicationException(Error error, HttpStatus status) {
        this(error.getMessage(), error, status);
    }*/

    public ApplicationException(String errorMessage, String errorCode, HttpStatus status) {
        super();
        this.errorInfo = new ErrorInfo();
        errorInfo.setMessage(errorMessage);
        errorInfo.setCode(errorCode);
        this.httpStatus = status;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }


    /**
     * Custom toString to print out the ErrorInfo object along with the stack trace.
     */
    @Override
    public String toString() {
        return new StringBuilder(super.toString()).toString();
    }

    @Override
    public String getMessage() {
        StringBuilder exceptionMessageBuilder = new StringBuilder();
        if (StringUtils.isNotBlank(super.getMessage())) {
            exceptionMessageBuilder.append(super.getMessage());
        }
        ErrorInfo errorInfo = this.getErrorInfo();
        if (errorInfo != null) {
            exceptionMessageBuilder.append("\n\t[ Error Code: ").append(errorInfo.getCode());
            exceptionMessageBuilder.append(" Error Message: ").append(errorInfo.getMessage())
                    .append(" ]");
        }
        return exceptionMessageBuilder.toString();
    }
}
