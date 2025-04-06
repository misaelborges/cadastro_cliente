package com.useall.cadastro_cliente.api.assembler;

import com.useall.cadastro_cliente.api.dto.ClienteResponseDTO;
import com.useall.cadastro_cliente.api.dto.ClienteResponseResumoDTO;
import com.useall.cadastro_cliente.api.dto.ClienteResquestAtualizacaoDTO;
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

    public ClienteResponseResumoDTO ToModelResumo(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseResumoDTO.class);
    }

    public ClienteResquestAtualizacaoDTO toModelAtualizacao(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResquestAtualizacaoDTO.class);
    }

    public List<ClienteResponseResumoDTO> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream().map(this::ToModelResumo).toList();
    }
}