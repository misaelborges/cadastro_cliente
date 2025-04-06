package com.useall.cadastro_cliente.api.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteResquestAtualizacaoDTO {

    @NotBlank(message = "Endereço não pode ser vazio")
    private String endereco;

    @NotBlank(message = "O telefone não pode ser vazio")
    private String telefone;

    public ClienteResquestAtualizacaoDTO() {
    }

    public ClienteResquestAtualizacaoDTO(String endereco, String telefone) {
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
