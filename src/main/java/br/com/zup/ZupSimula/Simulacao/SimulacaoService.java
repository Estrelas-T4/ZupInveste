package br.com.zup.ZupSimula.Simulacao;

import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoSaidaDTO;
import br.com.zup.ZupSimula.Simulacao.enuns.Risco;
import br.com.zup.ZupSimula.Simulacao.exceptions.ValorBaixoParaRiscoAltoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulacaoService {
    private List<SimulacaoDTO> mailing = new ArrayList<>();

    public void adicionarSimulacaoNaLista(SimulacaoDTO simulacaoDTO){
        varificarValorERisco(simulacaoDTO);
        mailing.add(simulacaoDTO);
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
        adicionarSimulacaoNaLista(simulacaoDTO);
        return calcularSimulacao(simulacaoDTO);
    }

    private void varificarValorERisco(SimulacaoDTO simulacaoDTO){
        if(simulacaoDTO.getRisco() == Risco.ALTO && simulacaoDTO.getValorInvestimento() < 5000.00){
            throw new ValorBaixoParaRiscoAltoException("Valor muito baixo para risco alto");
        }
    }

}
