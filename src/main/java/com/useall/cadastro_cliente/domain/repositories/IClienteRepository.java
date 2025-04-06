package com.useall.cadastro_cliente.domain.repositories;

import com.useall.cadastro_cliente.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByAtivoTrue();

}
