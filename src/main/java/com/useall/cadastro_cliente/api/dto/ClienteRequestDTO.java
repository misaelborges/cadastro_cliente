package com.useall.cadastro_cliente.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClienteRequestDTO {

    @NotBlank(message = "O campo Nome é obrigatório")
    String nome;

    @NotBlank(message = "O compao CNJP não pode ser invalido")
    String cnpj;

    @NotBlank(message = "O campo Endereço é obrigatório")
    String endereco;

    @Pattern(regexp = "^\\d{8,11}$", message = "O número de celular deve ter entre 8 e 11 dígitos.")
    String telefone;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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