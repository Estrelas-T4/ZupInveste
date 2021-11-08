package br.com.zup.ZupSimula.simulacao.dtos;

import br.com.zup.ZupSimula.simulacao.enuns.Risco;

public class SimulacaoResumoDTO {
    private String nome;
    private String email;
    private Risco risco;

    public SimulacaoResumoDTO() {
    }

    public SimulacaoResumoDTO(String nome, String email, Risco risco) {
        this.nome = nome;
        this.email = email;
        this.risco = risco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }
}
