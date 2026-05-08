package main;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import util.InterfaceUsuario;
import util.ArquivoUtil;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InterfaceUsuario iu = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("=== CADASTRO DE 1 FINANCIAMENTO PELO USUÁRIO ===");
        System.out.println("Escolha o tipo de imóvel:");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");
        int tipo = sc.nextInt();
        sc.nextLine(); // limpar buffer

        double valor = iu.pedirValorImovel();
        int prazo = iu.pedirPrazoFinanciamento();
        double taxa = iu.pedirTaxaJuros();

        if (tipo == 1) {
            System.out.println("Área construída (m²):");
            double areaConstruida = sc.nextDouble();
            System.out.println("Área do terreno (m²):");
            double areaTerreno = sc.nextDouble();
            financiamentos.add(new Casa(valor, prazo, taxa, areaConstruida, areaTerreno));
        } else if (tipo == 2) {
            System.out.println("Número de vagas na garagem:");
            int vagas = sc.nextInt();
            System.out.println("Número do andar:");
            int andar = sc.nextInt();
            financiamentos.add(new Apartamento(valor, prazo, taxa, vagas, andar));
        } else if (tipo == 3) {
            System.out.println("Tipo de zona (residencial ou comercial):");
            sc.nextLine();  // limpar buffer
            String zona = sc.nextLine();
            financiamentos.add(new Terreno(valor, prazo, taxa, zona));
        } else {
            System.out.println("Tipo inválido!");
        }

        System.out.println("=== Deseja adicionar financiamentos prontos de exemplo? ===");
        System.out.println("1 - Sim\n2 - Não");
        int continuar = sc.nextInt();
        sc.nextLine();

        if (continuar == 1) {
            financiamentos.add(new Casa(500000, 10, 0.10, 250, 400));
            financiamentos.add(new Casa(300000, 15, 0.08, 180, 300));
            financiamentos.add(new Apartamento(500000, 10, 0.10, 2, 5));
            financiamentos.add(new Apartamento(400000, 20, 0.09, 1, 10));
            financiamentos.add(new Terreno(200000, 10, 0.12, "Residencial"));
        }

        double totalImoveis = 0.0;
        double totalFinanciamentos = 0.0;

        System.out.println("\n=== RESUMO DE TODOS OS FINANCIAMENTOS ===");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento f = financiamentos.get(i);
            System.out.printf("Financiamento %d:\n", i + 1);
            f.mostrarResumo();
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.printf("%nTotal de todos os imóveis: R$ %.2f%n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalFinanciamentos);


        // ======== NOVO: Salvando e lendo arquivos =========
        System.out.println("\n=== Salvando financiamentos em arquivos ===");

        // 1) Salvar como texto
        ArquivoUtil.salvarComoCSV(financiamentos, "financiamentos.txt");

        // 2) Ler texto e mostrar na tela
        ArquivoUtil.lerCSV("financiamentos.txt");

        System.out.println();

        // 3) Salvar ArrayList inteiro como binário
        ArquivoUtil.salvarSerializado(financiamentos, "financiamentos.dat");

        // 4) Ler binário e mostrar todos os objetos
        ArrayList<Financiamento> listaLida = ArquivoUtil.lerSerializado("financiamentos.dat");
        if (listaLida != null) {
            System.out.println("\n=== RESUMO DOS FINANCIAMENTOS LIDOS DO ARQUIVO SERIALIZADO ===");
            for (Financiamento f : listaLida) {
                f.mostrarResumo();
            }
        }

        sc.close();
    }
}

