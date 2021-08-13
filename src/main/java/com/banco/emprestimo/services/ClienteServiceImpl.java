package com.banco.emprestimo.services;

import com.banco.emprestimo.dto.ClienteFiltro;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.repository.ClienteRepository;
import com.banco.emprestimo.services.specification.ClienteSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    private ClienteSpecification clienteSpecification = new ClienteSpecification();

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarCliente(Integer id) {
        return clienteRepository.getById(id);
    }

    @Override
    public List<Cliente> procurarClientes(ClienteFiltro clienteFiltro) {
        return clienteRepository.findAll(clienteSpecification.buscarPorCpfCliente(clienteFiltro.getCpf()).or(clienteSpecification.buscarPorDataContratacao(clienteFiltro.getDataContratação()).or(clienteSpecification.buscarPorNomeCliente(clienteFiltro.getNome()))));
    }

    @Override
    public List<Cliente> procurarClientesPotenciais() {
        return clienteRepository.findAll(clienteSpecification.buscarPorElegiveisAEmprestimo());
    }
}
