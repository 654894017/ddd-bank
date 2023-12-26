package com.example.bank.transaction.account.exception;

import ddd.core.exception.BizException;

public class InvalidCurrencyException extends BizException {
    public InvalidCurrencyException(String errMessage) {
        super(errMessage);
    }

    public InvalidCurrencyException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public InvalidCurrencyException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public InvalidCurrencyException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}