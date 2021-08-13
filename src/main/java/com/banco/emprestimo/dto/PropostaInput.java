package com.banco.emprestimo.dto;

import com.banco.emprestimo.model.Cliente;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class PropostaInput {
    private Double valor;
    private Double taxaJuros;
    private Integer cliente;
//    private LocalDateTime dataContratacao;
    private Integer numeroDeParcelas;

    public PropostaInput() {
    }

    public PropostaInput(Double valor, Double taxaJuros, Integer cliente,  Integer numeroDeParcelas) {
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.cliente = cliente;
//        this.dataContratacao = dataContratacao;
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

//    public LocalDateTime getDataContratacao() {
//        return dataContratacao;
//    }

//    public void setDataContratacao(LocalDateTime dataContratacao) {
//        this.dataContratacao = dataContratacao;
//    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
