package com.banco.emprestimo.controller;

import com.banco.emprestimo.dto.PropostaFiltro;
import com.banco.emprestimo.dto.PropostaInput;
import com.banco.emprestimo.dto.PropostaOutput;
import com.banco.emprestimo.errors.CustomExceptions;
import com.banco.emprestimo.model.Proposta;
import com.banco.emprestimo.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
        public ResponseEntity criarProposta(
            @RequestBody PropostaInput propostaInput)  {
        try {
            Proposta proposta = propostaService.criarProposta(propostaInput);
            return ResponseEntity.ok(new PropostaOutput(proposta.getValor(), proposta.getTaxaJuros(), proposta.getCliente().getNome(), proposta.getDataContratacao(), proposta.getStatus(), proposta.getParcelas()));
        }catch (CustomExceptions exceptions){
           return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(exceptions.getMessage());
        }
    }

    @GetMapping
    public List<PropostaOutput> buscarPorFiltro(
             PropostaFiltro propostaFiltro
            ){
        return propostaService.buscarPorFiltro(propostaFiltro).stream().map(PropostaOutput::converte).collect(Collectors.toList());
    }

    @PostMapping("aprovar")
    public PropostaOutput aprovarProposta(Integer codigoProposta){
        return PropostaOutput.converte(propostaService.aprovarProposta(codigoProposta));
    }


}
