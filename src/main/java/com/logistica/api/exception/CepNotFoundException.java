package com.logistica.api.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException(){
        super("CEP inexistente");
    }

}
