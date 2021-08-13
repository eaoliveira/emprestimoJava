package com.banco.emprestimo.controller;

import com.banco.emprestimo.dto.ClienteInput;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Conta;
import com.banco.emprestimo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Cliente salvarCliente(
            @RequestBody
                    ClienteInput clienteInput){
        Cliente cliente1 = new Cliente(clienteInput.getNome(),clienteInput.getCpf(),clienteInput.getPatrimonio(),clienteInput.getDataContratação(),clienteInput.getPatrimonio());
        Conta conta = new Conta(clienteInput.getConta().getSaldo(),clienteInput.getConta().getNumero(),clienteInput.getConta().getAgencia());
        cliente1.setContas(conta);
        return  clienteService.salvar(cliente1);
    }

    @GetMapping("potenciais")
    public List<Cliente> buscarPotenciais(){
        return  clienteService.procurarClientesPotenciais();
    }

}
