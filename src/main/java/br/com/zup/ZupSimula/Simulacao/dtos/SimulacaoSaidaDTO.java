package br.com.zup.ZupSimula.Simulacao.dtos;

public class SimulacaoSaidaDTO {
    private double valorInvestido;
    private double valorTotalDolucro;
    private double valorTotal;

    public SimulacaoSaidaDTO(double valorInvestido, double valorTotalDolucro, double valorTotal) {
        this.valorInvestido = valorInvestido;
        this.valorTotalDolucro = valorTotalDolucro;
        this.valorTotal = valorTotal;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getValorTotalDolucro() {
        return valorTotalDolucro;
    }

    public void setValorTotalDolucro(double valorTotalDolucro) {
        this.valorTotalDolucro = valorTotalDolucro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
