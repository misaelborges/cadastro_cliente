package com.useall.cadastro_cliente.api;

import com.useall.cadastro_cliente.api.dto.ClienteResponseDTO;
import com.useall.cadastro_cliente.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDTO ToModel(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream().map(this::ToModel).toList();
    }
}