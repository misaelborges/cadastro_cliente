package com.useall.cadastro_cliente.services;

import com.useall.cadastro_cliente.model.Cliente;
import com.useall.cadastro_cliente.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository repository;

    @Override
    public List<Cliente> bucarCliente() {
        return repository.findAll();
    }

    @Override
    public Optional<?> buscarClientePorId(Long codigo) {
        return repository.findById(codigo);
    }

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void excluirCliente(Long codigo) {
        repository.deleteById(codigo);
    }
}
