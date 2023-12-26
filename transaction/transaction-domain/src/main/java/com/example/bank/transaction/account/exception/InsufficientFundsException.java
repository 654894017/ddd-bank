package com.example.bank.transaction.account.exception;

import ddd.core.exception.BizException;

public class InsufficientFundsException extends BizException {

    public InsufficientFundsException(String errMessage) {
        super(errMessage);
    }

    public InsufficientFundsException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public InsufficientFundsException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public InsufficientFundsException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
