package com.banco.emprestimo.dto;

import com.banco.emprestimo.enums.StatusProposta;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Parcela;
import com.banco.emprestimo.model.Proposta;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PropostaOutput {
    private Double valor;
    private Double taxaJuros;
    private String nomeCliente;
    private LocalDateTime dataContratacao;
    private StatusProposta status;
    private List<Parcela> parcelas = new ArrayList<>();

    PropostaOutput(){}

    public PropostaOutput(Double valor, Double taxaJuros, String nomeCliente, LocalDateTime dataContratacao, StatusProposta status, List<Parcela> parcelas) {
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.nomeCliente = nomeCliente;
        this.dataContratacao = dataContratacao;
        this.status = status;
        this.parcelas = parcelas;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public void setStatus(StatusProposta status) {
        this.status = status;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public static PropostaOutput converte(Proposta proposta){
        return new PropostaOutput(proposta.getValor(), proposta.getTaxaJuros(), proposta.getCliente().getNome(), proposta.getDataContratacao(), proposta.getStatus(), proposta.getParcelas());
    }
}
