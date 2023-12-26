package com.example.bank.transaction.account.exception;

import ddd.core.exception.BizException;

public class AccountNotFoundException extends BizException {


    public AccountNotFoundException(String errMessage) {
        super(errMessage);
    }

    public AccountNotFoundException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public AccountNotFoundException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public AccountNotFoundException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
