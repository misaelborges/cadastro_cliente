package com.useall.cadastro_cliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_cliente", uniqueConstraints={@UniqueConstraint(columnNames = "cnpj")})
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @NotBlank(message = "O campo Nome é obrigatório")
    private String nome;

    @Column(name = "cnpj")
    private int cnpj;

    private LocalDate dataCadastro = LocalDate.now();

    @NotBlank(message = "O campo Endereço é obrigatório")
    private String endereco;

    private int telefone;

}
