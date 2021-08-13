package com.banco.emprestimo.model;

import com.banco.emprestimo.enums.StatusParcela;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    private Proposta proposta;
    private Double valor;
    private Integer numero;
    private LocalDateTime dataParcela;
    private StatusParcela status;

    public Parcela(){

    }

    public Parcela(Proposta proposta, Double valor, Integer numero, LocalDateTime dataParcela, StatusParcela status) {
        this.proposta = proposta;
        this.valor = valor;
        this.numero = numero;
        this.dataParcela = dataParcela;
        this.status = status;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public LocalDateTime getDataParcela() {
        return dataParcela;
    }

    public StatusParcela getStatus() {
        return status;
    }

    public void setStatus(StatusParcela status) {
        this.status = status;
    }
}
