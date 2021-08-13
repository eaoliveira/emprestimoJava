package com.banco.emprestimo.dto;

import com.banco.emprestimo.enums.StatusProposta;

public class PropostaFiltro {
    private String cpf;
    private StatusProposta statusProposta;

    public PropostaFiltro(String cpf, StatusProposta statusProposta) {
        this.cpf = cpf;
        this.statusProposta = statusProposta;
    }

    public PropostaFiltro() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusProposta getStatusProposta() {
        return statusProposta;
    }

    public void setStatusProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }
}
