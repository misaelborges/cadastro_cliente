package com.useall.cadastro_cliente.domain.model;

import com.useall.cadastro_cliente.api.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @CNPJ
    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @CreationTimestamp
    private LocalDate dataCadastro;

    private String endereco;

    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(ClienteRequestDTO clienteRequestDTO) {
        this.nome = clienteRequestDTO.getNome();
        this.cnpj = clienteRequestDTO.getCnpj();
        this.endereco = clienteRequestDTO.getEndereco();
        this.telefone = clienteRequestDTO.getTelefone();
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
