package com.useall.cadastro_cliente.api.controllers;

import com.useall.cadastro_cliente.domain.model.Cliente;
import com.useall.cadastro_cliente.domain.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> bucarCliente() {
        return ResponseEntity.status(200).body(service.bucarCliente());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(service.buscarClientePorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody Cliente cliente) {
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
