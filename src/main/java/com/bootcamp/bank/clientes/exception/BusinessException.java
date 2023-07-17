package com.bootcamp.bank.clientes.exception;

public class BusinessException extends RuntimeException{
    private String errorCode;
    private String messageError;

    public BusinessException(String messageError) {
        super(messageError);
        this.messageError = messageError;
    }


}
