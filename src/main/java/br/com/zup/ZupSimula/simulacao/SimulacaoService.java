package br.com.zup.ZupSimula.simulacao;

import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoSaidaDTO;
import br.com.zup.ZupSimula.simulacao.enuns.Risco;
import br.com.zup.ZupSimula.simulacao.exceptions.ValorBaixoParaRiscoAltoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimulacaoService {
    @Autowired
    private SimulacaoRepository simulacaoRepository;

    public void cadastrarSimulacaoNaLista(SimulacaoDTO simulacaoDTO){
        varificarValorERisco(simulacaoDTO);

        Simulacao simulacao = new Simulacao();
        simulacao.setCpf(simulacaoDTO.getCpf());
        simulacao.setEmail(simulacaoDTO.getEmail());
        simulacao.setRisco(simulacaoDTO.getRisco());
        simulacao.setPeriodoDeAplicacaoMeses(simulacaoDTO.getPeriodoDeAplicacaoMeses());
        simulacao.setValorInvestimento(simulacaoDTO.getValorInvestimento());
        simulacao.setNome(simulacaoDTO.getNome());

        simulacaoRepository.save(simulacao);
    }

    public SimulacaoSaidaDTO calcularSimulacao(SimulacaoDTO simulacaoDTO){
        double taxaDeRendimento = simulacaoDTO.getRisco().getTaxaDeRendimento();
        double valorAplicado = simulacaoDTO.getValorInvestimento();
        int periodoAplicado = simulacaoDTO.getPeriodoDeAplicacaoMeses();

        double valorDoLucro = 0;
        double valorTotal = valorAplicado;

        for(int i = 0; i < periodoAplicado; i++){
            valorDoLucro = valorDoLucro + (valorTotal * taxaDeRendimento);
            valorTotal = valorAplicado + valorDoLucro;
        }
        return new SimulacaoSaidaDTO(valorAplicado, valorDoLucro, valorTotal);
    }

    public SimulacaoSaidaDTO realizarSimulacao(SimulacaoDTO simulacaoDTO){
        cadastrarSimulacaoNaLista(simulacaoDTO);
        return calcularSimulacao(simulacaoDTO);
    }

    private void varificarValorERisco(SimulacaoDTO simulacaoDTO){
        if(simulacaoDTO.getRisco() == Risco.ALTO && simulacaoDTO.getValorInvestimento() < 5000.00){
            throw new ValorBaixoParaRiscoAltoException("Valor muito baixo para risco alto");
        }
    }

    public List<Simulacao> exibirTodasAsSimulacoes(Risco risco){
        if(risco != null){
            return simulacaoRepository.findAllByRisco(risco);
        }
        Iterable<Simulacao> simulacaos = simulacaoRepository.findAll();
        return (List<Simulacao>) simulacaos;
    }

    public Simulacao buscarPorID(int id){
        Optional<Simulacao> simulacao = simulacaoRepository.findById(id);
        if (simulacao.isEmpty()){
            throw new RuntimeException("Não encontrado");
        }
        return simulacao.get();
    }
}
