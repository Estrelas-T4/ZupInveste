package br.com.zup.ZupSimula.simulacao;

import br.com.zup.ZupSimula.simulacao.enuns.Risco;

import javax.persistence.*;

@Entity
@Table(name = "simulacoes")
//lombok
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true) // Column para minupular a tabela. unique true para tornar o campo unico
    private String email;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(name = "valor_investimento") // name serve para referenciar coluna ou mudar o nome dela
    private double valorInvestimento;
    @Column(name = "periodo_de_aplicacao_em_meses")
    private int periodoDeAplicacaoMeses;
    @Enumerated(EnumType.STRING)
    private Risco risco;

    public Simulacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public int getPeriodoDeAplicacaoMeses() {
        return periodoDeAplicacaoMeses;
    }

    public void setPeriodoDeAplicacaoMeses(int periodoDeAplicacaoMeses) {
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }
}
