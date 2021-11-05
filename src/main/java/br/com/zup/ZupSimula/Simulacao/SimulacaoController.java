package br.com.zup.ZupSimula.Simulacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;


}
