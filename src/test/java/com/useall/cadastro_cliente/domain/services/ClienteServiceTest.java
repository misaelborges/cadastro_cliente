package com.useall.cadastro_cliente.domain.services;

import com.useall.cadastro_cliente.domain.model.Cliente;
import com.useall.cadastro_cliente.domain.repositories.IClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private IClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Misael", "32225099000116", "Rua Henrique Lages", "48998748525");
    }

    @Test
    void listarClientesAtivos() {
        given(clienteRepository.findByAtivoTrue()).willReturn(List.of(cliente));

        List<Cliente> clientes = clienteService.listarClientesAtivos();

        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

    @Test
    void buscarClientePorId() {
        given(clienteRepository.findById(anyLong())).willReturn(Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.buscarClientePorId(1L);

        System.out.println(clienteEncontrado.getId());
        assertNotNull(clienteEncontrado);
        assertEquals(clienteEncontrado.getId(), cliente.getId());
    }

    @Test
    void salvarCliente() {
        given(clienteRepository.save(cliente)).willReturn(cliente);

        Cliente clienteSalva = clienteService.salvarCliente(cliente);

        assertNotNull(clienteSalva);
        assertEquals(cliente, clienteSalva);
    }

    @Test
    void atualizarCliente() {
        cliente.setNome("Testando");

        given(clienteRepository.save(cliente)).willReturn(cliente);

        Cliente clienteAtualizado = clienteService.atualizarCliente(cliente);

        assertNotNull(clienteAtualizado);
        assertEquals("Testando", clienteAtualizado.getNome());
    }

    @Test
    void excluirCliente() {
        given(clienteRepository.findById(anyLong())).willReturn(Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.buscarClientePorId(1L);
        clienteService.excluirCliente(1L);

        assertEquals(Boolean.FALSE, clienteEncontrado.getAtivo());
    }

    @Test
    void buscarClientePorCnpj() {
        given(clienteRepository.findByCnpj(anyString())).willReturn(Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.buscarClientePorCnpj("32225099000116");

        assertNotNull(clienteEncontrado);
        assertEquals(cliente.getNome(), clienteEncontrado.getNome());
    }

}