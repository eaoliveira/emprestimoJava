package com.banco.emprestimo.repository;

import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> {
    public Conta findByCliente(Cliente cliente);
}
