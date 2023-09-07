package com.useall.cadastro_cliente.services;

import com.useall.cadastro_cliente.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> bucarCliente();
    Optional<?> buscarClientePorId(Long codigo);
    Cliente salvarCliente(Cliente cliente);
    Cliente atualizarCliente(Cliente cliente);
    void excluirCliente(Long codigo);
}
