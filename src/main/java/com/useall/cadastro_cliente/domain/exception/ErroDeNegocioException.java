package com.useall.cadastro_cliente.domain.exception;

public class ErroDeNegocioException extends RuntimeException{

    public ErroDeNegocioException() {
    }

    public ErroDeNegocioException(String message) {
        super(message);
    }

}
