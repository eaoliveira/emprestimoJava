package com.banco.emprestimo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Double patrimonio;
    private LocalDateTime dataContratacao;
    private Double salario;
//    @JsonBackReference
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
//    private List<Conta> contas = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private  Conta contas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Proposta> propostas = new ArrayList<>();

    public Cliente(){}
    public Cliente(String nome, String cpf, Double patrimonio, LocalDateTime dataContratacao, Double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.patrimonio = patrimonio;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
//        this.contas = conta;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public LocalDateTime getDataContratação() {
        return dataContratacao;
    }

    public void setDataContratação(LocalDateTime dataContratação) {
        this.dataContratacao = dataContratação;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Conta getContas() {
        return contas;
    }

    public void setContas(Conta contas) {
        this.contas = contas;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    public boolean clienteElegivel(Double valorEmprestimo){
        if(dataContratacao.isBefore(LocalDateTime.now().minusMonths(3))){
            return true;
        }

        if(patrimonio>valorEmprestimo){
            return true;
        }

        return  false;
    }


    public boolean parcelaValida(Double valorParcela){

        if(valorParcela>=(salario*0.15)) return  false;

        return true;
    }

}
