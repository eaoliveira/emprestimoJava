package com.banco.emprestimo.services.specification;

import com.banco.emprestimo.model.Cliente;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ClienteSpecification {

    public Specification<Cliente> buscarPorNomeCliente(String nome){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"),"%"+nome+"%"));
    }

    public Specification<Cliente> buscarPorCpfCliente(String cpf){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("cpf"),"%"+cpf+"%"));
    }

    public Specification<Cliente> buscarPorDataContratacao(LocalDateTime dataContratacao){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("dataContratacao"),dataContratacao));
    }

    public Specification<Cliente> buscarPorElegiveisAEmprestimo(){
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("dataContratacao"),LocalDateTime.now().minusMonths(3)));
    }
}
