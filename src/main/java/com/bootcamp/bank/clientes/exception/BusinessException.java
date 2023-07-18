package com.bootcamp.bank.clientes.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String messageError) {
        super(messageError);
    }


}
