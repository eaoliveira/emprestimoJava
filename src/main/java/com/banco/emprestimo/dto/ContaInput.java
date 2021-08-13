package com.banco.emprestimo.dto;

public class ContaInput {
    private Long  saldo;
    private String numero;
    private String agencia;
//    private  Integer clienteId;

    public ContaInput() {
    }

    public ContaInput(Long saldo, String numero, String agencia, Integer clienteId) {
        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
//        this.clienteId = clienteId;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
//
//    public Integer getClienteId() {
//        return clienteId;
//    }
//
//    public void setClienteId(Integer clienteId) {
//        this.clienteId = clienteId;
//    }
}
