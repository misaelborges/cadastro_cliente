package com.useall.cadastro_cliente.controllers;

import com.useall.cadastro_cliente.model.Cliente;
import com.useall.cadastro_cliente.services.ClienteServiceImpl;
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
    private ClienteServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Cliente>> bucarCliente() {
        return ResponseEntity.status(200).body(service.bucarCliente());
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long codigo) {
        return ResponseEntity.status(200).body(service.buscarClientePorId(codigo));
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(201).body(service.salvarCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(200).body(service.atualizarCliente(cliente));
    }

    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity<?> excluirCliente(@PathVariable Long codigo) {
        service.excluirCliente(codigo);
        return ResponseEntity.status(204).build();
    }

}
