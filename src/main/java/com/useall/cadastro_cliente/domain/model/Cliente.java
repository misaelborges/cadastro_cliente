package com.useall.cadastro_cliente.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_cliente", uniqueConstraints={@UniqueConstraint(columnNames = "cnpj")})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nome;

    @Column(name = "cnpj")
    private int cnpj;

    @CreationTimestamp
    private LocalDate dataCadastro;

    private String endereco;

    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, int cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
