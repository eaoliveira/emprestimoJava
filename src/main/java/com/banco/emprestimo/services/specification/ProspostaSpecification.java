package com.banco.emprestimo.services.specification;

import com.banco.emprestimo.enums.StatusProposta;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Proposta;
import org.springframework.data.jpa.domain.Specification;

public class ProspostaSpecification {
    public Specification<Proposta> buscarPorCpfCliente(String cpf){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.join("cliente").get("cpf"),"%"+cpf+"%"));
    }

    public Specification<Proposta> buscarPoStatus(StatusProposta statusProposta){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), statusProposta));
    }
}
