package com.useall.cadastro_cliente.api;

import com.useall.cadastro_cliente.api.dto.ClienteRequestDTO;
import com.useall.cadastro_cliente.core.modelmapper.ModelMapperConfig;
import com.useall.cadastro_cliente.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toDomainObject(ClienteRequestDTO clienteRequestDTO) {
        return modelMapper.map(clienteRequestDTO, Cliente.class);
    }
}
