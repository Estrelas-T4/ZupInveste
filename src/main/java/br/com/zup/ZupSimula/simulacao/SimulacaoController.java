package br.com.zup.ZupSimula.simulacao;

import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoDTO;
import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoResumoDTO;
import br.com.zup.ZupSimula.simulacao.dtos.SimulacaoSaidaDTO;
import br.com.zup.ZupSimula.simulacao.enuns.Risco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @PutMapping
    public SimulacaoSaidaDTO simularInvestimento(@RequestBody @Valid SimulacaoDTO simulacaoDTO){
        return simulacaoService.realizarSimulacao(simulacaoDTO);
    }

    @GetMapping
    public List<SimulacaoResumoDTO> exibirSimulacoesCadastradas(@RequestParam(required = false) Risco risco) {
        List<SimulacaoResumoDTO> simulacaoResumoDTOS = new ArrayList<>();
        for (Simulacao simulacao : simulacaoService.exibirTodasAsSimulacoes(risco)) {
            simulacaoResumoDTOS.add(
                    new SimulacaoResumoDTO(simulacao.getNome(), simulacao.getEmail(), simulacao.getRisco()));
        }
        return simulacaoResumoDTOS;
    }

    @GetMapping("/{id}")
    public Simulacao buscarSimulacaoPeloID(@PathVariable int id){
        return simulacaoService.buscarPorID(id);
    }

}
