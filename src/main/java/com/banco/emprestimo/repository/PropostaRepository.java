package com.banco.emprestimo.repository;

import com.banco.emprestimo.model.Conta;
import com.banco.emprestimo.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Integer>, JpaSpecificationExecutor<Proposta> {
}
