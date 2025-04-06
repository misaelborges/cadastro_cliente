package com.useall.cadastro_cliente.domain.exception;

public class ClienteNaoEcontradoException extends ErroDeNegocioException{

    public ClienteNaoEcontradoException() {
    }

    public ClienteNaoEcontradoException(String message) {
        super(message);
    }

    public ClienteNaoEcontradoException(Long id) {
        super(String.format("O cliente com o id %d não foi encontrado no nosso sistema", id));
    }
}
