package br.com.zup.ZupSimula.simulacao;

import br.com.zup.ZupSimula.simulacao.enuns.Risco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SimulacaoRepository extends CrudRepository<Simulacao, Integer> {
    List<Simulacao> findAllByRisco(Risco risco);
}
