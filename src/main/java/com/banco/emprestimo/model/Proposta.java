package com.banco.emprestimo.model;

import com.banco.emprestimo.enums.StatusProposta;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proposta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;
    private Double taxaJuros;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    private LocalDateTime dataContratacao;
    private StatusProposta status;
    @OneToMany(mappedBy = "proposta", cascade = CascadeType.ALL)
    private List<Parcela> parcelas = new ArrayList<>();

    public Proposta(){}

    public Proposta(Double valor, Double taxaJuros, Cliente cliente, LocalDateTime dataContratacao, StatusProposta status) {
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.cliente = cliente;
        this.dataContratacao = dataContratacao;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setStatus(StatusProposta status) {
        this.status = status;
    }

    public void adicionaParcela(Parcela parcela){
        this.parcelas.add(parcela);
    }
}
