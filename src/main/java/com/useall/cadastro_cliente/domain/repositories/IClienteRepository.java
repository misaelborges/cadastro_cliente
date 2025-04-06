package com.useall.cadastro_cliente.domain.repositories;

import com.useall.cadastro_cliente.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByAtivoTrue();
    Optional<Cliente> findByCnpj(String cnpj);

}
