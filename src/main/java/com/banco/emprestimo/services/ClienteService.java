package com.banco.emprestimo.services;

import com.banco.emprestimo.dto.ClienteFiltro;
import com.banco.emprestimo.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente salvar(Cliente cliente);
    Cliente buscarCliente(Integer id);
    List<Cliente> procurarClientes(ClienteFiltro clienteFiltro);
    List<Cliente> procurarClientesPotenciais();

}
