package com.banco.emprestimo.services;

import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Conta;
import com.banco.emprestimo.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;

    @Override
    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Conta buscarPorCliente(Cliente cliente) {
        return buscarPorCliente(cliente);
    }
}
