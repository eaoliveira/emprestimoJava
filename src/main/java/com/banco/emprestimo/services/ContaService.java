package com.banco.emprestimo.services;

import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Conta;

public interface ContaService {
    Conta salvar(Conta conta);
    Conta buscarPorCliente(Cliente cliente);
}
