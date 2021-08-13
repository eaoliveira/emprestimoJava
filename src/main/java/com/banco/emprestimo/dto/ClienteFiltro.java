package com.banco.emprestimo.dto;

import java.time.LocalDateTime;

public class ClienteFiltro {
    private String nome;
    private String cpf;
    private LocalDateTime dataContratação;

    ClienteFiltro(){}

    public ClienteFiltro(String nome, String cpf, LocalDateTime dataContratação) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataContratação = dataContratação;
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

    public LocalDateTime getDataContratação() {
        return dataContratação;
    }

    public void setDataContratação(LocalDateTime dataContratação) {
        this.dataContratação = dataContratação;
    }
}
