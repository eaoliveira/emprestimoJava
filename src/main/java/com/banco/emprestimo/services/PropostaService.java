package com.banco.emprestimo.services;

import com.banco.emprestimo.dto.PropostaFiltro;
import com.banco.emprestimo.dto.PropostaInput;
import com.banco.emprestimo.errors.CustomExceptions;
import com.banco.emprestimo.model.Parcela;
import com.banco.emprestimo.model.Proposta;

import java.util.List;

public interface PropostaService {
    Proposta criarProposta(PropostaInput propostaInput) throws CustomExceptions;
    Proposta aprovarProposta(Integer id);
    List<Proposta> buscarPorFiltro(PropostaFiltro propostaFiltro);
    List<Parcela> buscarParcelas(Integer id);
}
