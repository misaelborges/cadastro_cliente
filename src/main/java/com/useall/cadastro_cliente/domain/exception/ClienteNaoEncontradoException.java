package com.useall.cadastro_cliente.domain.exception;

public class ClienteNaoEncontradoException extends ErroDeNegocioException{

    public ClienteNaoEncontradoException() {
    }

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(Long id) {
        super(String.format("O cliente com o id %d não foi encontrado no nosso sistema", id));
    }
}
