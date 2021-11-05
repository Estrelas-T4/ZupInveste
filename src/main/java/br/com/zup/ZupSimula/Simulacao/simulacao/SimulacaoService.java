package br.com.zup.ZupSimula.Simulacao.simulacao;

import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoSaidaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulacaoService {
    private List<SimulacaoDTO> mailing = new ArrayList<>();

    public void adicionarSimulacaoNaLista(SimulacaoDTO simulacaoDTO){
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
            valorTotal = valorTotal + valorDoLucro;
        }

        return new SimulacaoSaidaDTO(valorAplicado, valorDoLucro, valorTotal);
    }

    public SimulacaoSaidaDTO realizarSimulacao(SimulacaoDTO simulacaoDTO){
        adicionarSimulacaoNaLista(simulacaoDTO);
        return calcularSimulacao(simulacaoDTO);
    }

}
