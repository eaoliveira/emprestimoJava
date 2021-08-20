package com.banco.emprestimo.services;

import com.banco.emprestimo.dto.PagarParcelaDto;
import com.banco.emprestimo.dto.PropostaFiltro;
import com.banco.emprestimo.dto.PropostaInput;
import com.banco.emprestimo.enums.StatusParcela;
import com.banco.emprestimo.enums.StatusProposta;
import com.banco.emprestimo.errors.CustomExceptions;
import com.banco.emprestimo.model.Cliente;
import com.banco.emprestimo.model.Parcela;
import com.banco.emprestimo.model.Proposta;
import com.banco.emprestimo.repository.PropostaRepository;
import com.banco.emprestimo.services.specification.ProspostaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PropostaServiceImpl implements PropostaService{

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    ClienteService clienteService;

    @Override
    public Proposta criarProposta(PropostaInput propostaInput) throws CustomExceptions {
        return propostaRepository.save(calcularParcelas(propostaInput));
    }

    @Override
    public Proposta aprovarProposta(Integer id) {
        Proposta proposta = propostaRepository.getById(id);
        proposta.setStatus(StatusProposta.APROVADO);
        return propostaRepository.save(proposta);
    }

    @Override
    public List<Proposta> buscarPorFiltro(PropostaFiltro propostaFiltro) {
        ProspostaSpecification prospostaSpecification = new ProspostaSpecification();
        return propostaRepository.findAll(prospostaSpecification.buscarPorCpfCliente(propostaFiltro.getCpf()).or(prospostaSpecification.buscarPoStatus(propostaFiltro.getStatusProposta())));
    }

    @Override
    public List<Parcela> buscarParcelas(Integer id) {
        return propostaRepository.getById(id).getParcelas();
    }



    private Parcela buscarParcelasPorId(List<Parcela> parcelas, Integer id) {
        return parcelas.stream().filter(i->i.getNumero().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Proposta pagarParcela(PagarParcelaDto pagarParcelaDto) throws CustomExceptions {

        Proposta proposta = propostaRepository.getById(pagarParcelaDto.getProposta());

        if(proposta.getStatus()!=StatusProposta.APROVADO){
            throw new CustomExceptions("Proposta Não aprovada");
        };


//        Parcela parcela=  buscarParcelas(pagarParcelaDto.getProposta()).get(pagarParcelaDto.getParcela()+1);
       try {
           Parcela parcela = buscarParcelasPorId(buscarParcelas(pagarParcelaDto.getProposta()), pagarParcelaDto.getParcela());
           if(parcela.getStatus()!=StatusParcela.PENDENTE){
               throw new CustomExceptions("Parcela não disponivel para pagamento");
           };
           parcela.setDataPagamento(LocalDateTime.now());
           parcela.setStatus(StatusParcela.PAGA);
           return propostaRepository.save(proposta);
       }catch (NullPointerException nullPointerException){
            throw new CustomExceptions("Parcela não encontrada");
       }



    }

    private Proposta calcularParcelas(PropostaInput proposta) throws CustomExceptions {
        Cliente cliente = clienteService.buscarCliente(proposta.getCliente());

        if(!cliente.clienteElegivel(proposta.getValor())){
             throw new CustomExceptions("Cliente Não elegivel ao Emprestimo");
        };

        Proposta proposta1 = new Proposta(proposta.getValor(),proposta.getTaxaJuros(),cliente,LocalDateTime.now(),StatusProposta.AVALIACAO);
        var valorParcela = proposta.getValor() / proposta.getNumeroDeParcelas();
        valorParcela=valorParcela+(proposta.getTaxaJuros()/100*valorParcela);

        if(!cliente.parcelaValida(valorParcela)){
            throw new CustomExceptions("Parcela maior que 30%");
        }
        for(int i=1;i<=proposta.getNumeroDeParcelas();i++){
            Parcela parcela = new Parcela(proposta1,valorParcela,i, LocalDateTime.now().plusMonths(i), StatusParcela.PENDENTE);
            proposta1.adicionaParcela(parcela);
        }
        return  proposta1;
    }


}
