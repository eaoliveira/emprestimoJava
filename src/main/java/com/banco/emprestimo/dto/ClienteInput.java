package com.banco.emprestimo.dto;

import com.banco.emprestimo.model.Conta;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteInput {
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    private Double patrimonio;
    @NonNull
    private LocalDateTime dataContratação;
    @NonNull
    private Double salario;
    private ContaInput conta;

    public ClienteInput(){}

    public ClienteInput(String nome, String cpf, Double patrimonio, LocalDateTime dataContratação, ContaInput conta, Double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.patrimonio = patrimonio;
        this.dataContratação = dataContratação;
        this.salario = salario;
        this.conta = conta;
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
        return dataContratação;
    }

    public void setDataContratação(LocalDateTime dataContratação) {
        this.dataContratação = dataContratação;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public ContaInput getConta() {
        return conta;
    }

    public void setConta(ContaInput conta) {
        this.conta = conta;
    }
}
