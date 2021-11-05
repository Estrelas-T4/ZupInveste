package br.com.zup.ZupSimula.Simulacao.simulacao;

import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulacaoService {
    private List<SimulacaoDTO> simulacaoDTOS = new ArrayList<>();

    public void adicionarSimulacaoNaLista(SimulacaoDTO simulacaoDTO){
        simulacaoDTOS.add(simulacaoDTO);
    }
}
