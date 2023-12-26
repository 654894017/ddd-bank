package com.example.bank.transaction.account.exception;

import ddd.core.exception.BizException;

/**
 * 超出日限额异常
 */
public class DailyLimitExceededException extends BizException {

    public DailyLimitExceededException(String errMessage) {
        super(errMessage);
    }

    public DailyLimitExceededException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public DailyLimitExceededException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public DailyLimitExceededException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}
