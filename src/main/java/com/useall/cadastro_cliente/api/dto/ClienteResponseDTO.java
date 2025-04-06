package com.useall.cadastro_cliente.api.dto;

import java.time.LocalDate;

public class ClienteResponseDTO {

    private String nome;
    private String cnpj;
    private LocalDate dataCadastro;
    private String endereco;
    private String telefone;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nome, String cnpj, LocalDate dataCadastro, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.dataCadastro = dataCadastro;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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
