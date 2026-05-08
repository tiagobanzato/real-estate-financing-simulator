package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double valorImovel;
    protected double taxaJurosAnual;
    protected int prazoFinanciamento; // em anos

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();
    public abstract double calcularTotalPagamento();

    protected double calcularTaxaMensal() {
        return taxaJurosAnual / 12.0;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public void mostrarResumo() {
        System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Taxa de juros anual: %.2f%%\n", taxaJurosAnual * 100);
        System.out.printf("Prazo do financiamento: %d anos\n", prazoFinanciamento);
        System.out.printf("Pagamento mensal: R$ %.2f\n", calcularPagamentoMensal());
        System.out.printf("Valor total do financiamento: R$ %.2f\n", calcularTotalPagamento());
    }
}
