package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }


    public double calcularPagamentoMensal() {
        double taxaMensal = calcularTaxaMensal();
        int totalParcelas = prazoFinanciamento * 12;
        if (taxaMensal == 0.0) {
            return (valorImovel / totalParcelas) * 1.02;
        } else {
            double fator = Math.pow(1 + taxaMensal, totalParcelas);
            double parcelaBase = valorImovel * taxaMensal * fator / (fator - 1);
            return parcelaBase * 1.02;
        }
    }


    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }


    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Tipo de zona: %s\n", tipoZona);
        System.out.println("-----------------------------");
    }
    public String toCSV() {
        return String.format("Terreno;%.2f;%.2f;%.4f;%d;%s",
                valorImovel,
                calcularTotalPagamento(),
                taxaJurosAnual,
                prazoFinanciamento,
                tipoZona);
    }
}

