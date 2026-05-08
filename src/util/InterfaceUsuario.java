package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = Double.parseDouble(scanner.nextLine().replace(",", "."));
                if (valor <= 0.0) {
                    System.out.println("️ O valor deve ser positivo!");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um número válido (ex: 300000.50).");
            }
        }

        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazo = Integer.parseInt(scanner.nextLine());
                if (prazo <= 0) {
                    System.out.println("️ O prazo deve ser maior que zero!");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um número inteiro válido (ex: 10).");
            }
        }

        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("Digite a taxa de juros anual:");
                System.out.println("- Use valores decimais. Exemplo: 0.08 para 8%");
                System.out.print("→ Taxa (entre 0.01 e 1.0): ");
                String entrada = scanner.nextLine().replace(",", ".");
                taxa = Double.parseDouble(entrada);
                if (taxa >= 0.01 && taxa <= 1.0) {
                    valido = true;
                } else {
                    System.out.println(" Valor fora do intervalo permitido (0.01 - 1.0). Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um número decimal válido (ex: 0.08).");
            } finally {
                System.out.println("→ Entrada de taxa processada.\n");
            }
        }

        return taxa;
    }
    
}