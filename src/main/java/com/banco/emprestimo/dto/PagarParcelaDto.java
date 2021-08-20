package com.banco.emprestimo.dto;

public class PagarParcelaDto {
    private Integer parcela;
    private Integer proposta;

    public PagarParcelaDto(){}

    public PagarParcelaDto(Integer parcela, Integer proposta) {
        this.parcela = parcela;
        this.proposta = proposta;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Integer getProposta() {
        return proposta;
    }

    public void setProposta(Integer proposta) {
        this.proposta = proposta;
    }
}
