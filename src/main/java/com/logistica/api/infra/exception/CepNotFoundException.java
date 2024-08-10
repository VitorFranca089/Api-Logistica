package com.logistica.api.infra.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException(){
        super("CEP inexistente");
    }

}
