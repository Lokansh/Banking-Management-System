package com.bankingmanagement.bankingmanagement.database;

public class DatabaseConnectionException extends Exception {
    private final String errMsg;
    private final Throwable error;

    public DatabaseConnectionException(String message, Throwable error) {
        super(message, error);
        this.errMsg = message;
        this.error = error;
    }

    public String geterrMsg() {
        return errMsg;
    }

    @Override
    public String toString() {
        return "DatabaseConnectionException{" +
                "errMsg='" + errMsg + '\'' +
                ", error=" + error +
                '}';
    }

    public Throwable getError() {
        return error;
    }
}