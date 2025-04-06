package com.useall.cadastro_cliente.api.controllers;

import com.useall.cadastro_cliente.api.ClienteRequestDisassembler;
import com.useall.cadastro_cliente.api.ClienteResponseAssembler;
import com.useall.cadastro_cliente.api.dto.ClienteRequestDTO;
import com.useall.cadastro_cliente.api.dto.ClienteResponseDTO;
import com.useall.cadastro_cliente.domain.model.Cliente;
import com.useall.cadastro_cliente.domain.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRequestDisassembler clienteRequestDisassembler;

    @Autowired
    private ClienteResponseAssembler clienteResponseAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponseDTO> bucarCliente() {
        List<Cliente> clienteList = service.bucarCliente();
        List<ClienteResponseDTO> clienteResponseDTOS = clienteResponseAssembler.toCollectionModel(clienteList);
        return clienteResponseDTOS;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = service.buscarClientePorId(id);
        return clienteResponseAssembler.ToModel(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRequestDisassembler.toDomainObject(clienteRequestDTO);
        return ResponseEntity.status(201).body(service.salvarCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(200).body(service.atualizarCliente(cliente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable Long id) {
        service.excluirCliente(id);
        return ResponseEntity.status(204).build();
    }

}
