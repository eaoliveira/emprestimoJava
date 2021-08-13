package com.banco.emprestimo.controller;

import com.banco.emprestimo.dto.ContaInput;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Conta;
import com.banco.emprestimo.services.ClienteService;
import com.banco.emprestimo.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ContaService contaService;
//
//    @PostMapping
//    @ResponseBody
//    public Conta salvarConta(@RequestBody ContaInput conta){
////        Cliente cliente = clienteService.buscarCliente(conta.getClienteId());
//        Conta conta1 = new Conta(cliente,conta.getSaldo(),conta.getNumero(),conta.getAgencia());
//        return contaService.salvar(conta1);
//    }
}
