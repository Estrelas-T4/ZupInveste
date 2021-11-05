package br.com.zup.ZupSimula.Simulacao;

import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.Simulacao.dtos.SimulacaoSaidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @PutMapping
    public SimulacaoSaidaDTO simularInvestimento(@RequestBody SimulacaoDTO simulacaoDTO){
        return simulacaoService.realizarSimulacao(simulacaoDTO);
    }
}
