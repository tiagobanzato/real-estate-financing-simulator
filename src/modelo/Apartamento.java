package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                       int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }


    public double calcularPagamentoMensal() {
        double i = calcularTaxaMensal();
        int n = prazoFinanciamento * 12;

        if (i == 0.0) {
            return valorImovel / n;
        } else {
            double fator = Math.pow(1 + i, n);
            return (valorImovel * i * fator) / (fator - 1);
        }
    }


    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }


    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Número de vagas na garagem: %d\n", vagasGaragem);
        System.out.printf("Número do andar: %d\n", numeroAndar);
        System.out.println("-----------------------------");
    }
    public String toCSV() {
        return String.format("Apartamento;%.2f;%.2f;%.4f;%d;%d;%d",
                valorImovel,
                calcularTotalPagamento(),
                taxaJurosAnual,
                prazoFinanciamento,
                vagasGaragem,
                numeroAndar);
    }
}

