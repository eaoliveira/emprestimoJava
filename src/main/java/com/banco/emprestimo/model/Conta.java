package com.banco.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Conta {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    private Long  saldo;
    private String numero;
    private String agencia;

    public Conta( Long saldo, String numero, String agencia) {
//        this.cliente = cliente;
        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
    }

    public Conta(){

    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Long getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }
}
