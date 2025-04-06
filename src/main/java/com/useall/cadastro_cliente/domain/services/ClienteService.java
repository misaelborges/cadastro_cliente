package com.useall.cadastro_cliente.domain.services;

import com.useall.cadastro_cliente.domain.exception.ClienteNaoEncontradoException;
import com.useall.cadastro_cliente.domain.model.Cliente;
import com.useall.cadastro_cliente.domain.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository repository;

    public List<Cliente> listarClientesAtivos() {
        return repository.findByAtivoTrue();
    }

    public Cliente buscarClientePorId(Long id) {
        Cliente cliente = buscador(id);
        if (cliente.getAtivo().equals(false)) {
            throw new ClienteNaoEncontradoException(id);
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

    public Cliente buscarClientePorCnpj(String cnpj) {
        Optional<Cliente> cliente = repository.findByCnpj(cnpj);
        if (cliente.isEmpty()) {
            throw new ClienteNaoEncontradoException(String.format("Não existe nenhum cliente com o cnpj %s", cnpj));
        }
        return cliente.get();
    }

    public Cliente buscador(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }
}
