package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }


    public double calcularPagamentoMensal() {
        double taxaMensal = calcularTaxaMensal();
        int totalParcelas = prazoFinanciamento * 12;
        double parcelaBase;

        if (taxaMensal == 0.0) {
            parcelaBase = valorImovel / totalParcelas;
        } else {
            double fator = Math.pow(1 + taxaMensal, totalParcelas);
            parcelaBase = valorImovel * taxaMensal * fator / (fator - 1);
        }

        try {
            verificarAumento(parcelaBase);
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println(" ERRO: " + e.getMessage());
        }

        return parcelaBase + 80;
    }

    private void verificarAumento(double parcelaBase) throws AumentoMaiorDoQueJurosException {
        double jurosParte = parcelaBase - (valorImovel / (prazoFinanciamento * 12));
        if (jurosParte > 0 && 80 > (jurosParte / 2)) {
            throw new AumentoMaiorDoQueJurosException(
                    String.format("O acréscimo fixo de R$80 excede a metade dos juros calculados (metade: %.2f).", jurosParte / 2)
            );
        }
    }


    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }


    public void mostrarResumo() {
        super.mostrarResumo();
        System.out.printf("Área construída: %.2f m²\n", areaConstruida);
        System.out.printf("Área do terreno: %.2f m²\n", areaTerreno);
        System.out.println("-----------------------------");
    }
    public String toCSV() {
        return String.format("Casa;%.2f;%.2f;%.4f;%d;%.2f;%.2f",
                valorImovel,
                calcularTotalPagamento(),
                taxaJurosAnual,
                prazoFinanciamento,
                areaConstruida,
                areaTerreno);
    }
}
