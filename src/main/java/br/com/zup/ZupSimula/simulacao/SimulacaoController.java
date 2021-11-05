package br.com.zup.ZupSimula.simulacao;

import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoSaidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @PutMapping
    public SimulacaoSaidaDTO simularInvestimento(@RequestBody @Valid SimulacaoDTO simulacaoDTO){
        return simulacaoService.realizarSimulacao(simulacaoDTO);
    }
}
