package com.useall.cadastro_cliente.domain.services;

import com.useall.cadastro_cliente.domain.exception.ClienteNaoEcontradoException;
import com.useall.cadastro_cliente.domain.model.Cliente;
import com.useall.cadastro_cliente.domain.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository repository;

    public List<Cliente> bucarCliente() {
        return repository.findByAtivoTrue();
    }

    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = buscador(id);
        if (cliente.getAtivo().equals(false)) {
            throw new ClienteNaoEcontradoException(id);
        }
        return cliente;
    }

    public Cliente salvarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    public void excluirCliente(Long id) {
        Cliente cliente = buscador(id);
        cliente.setAtivo(false);
    }

    public Cliente buscador(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteNaoEcontradoException(id));
    }
}
