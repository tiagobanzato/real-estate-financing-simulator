package util;

import modelo.Financiamento;
import modelo.Salvavel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {


    public static void salvarComoCSV(List<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento f : financiamentos) {
                if (f instanceof Salvavel) {
                    writer.write(((Salvavel) f).toCSV());
                    writer.newLine();
                }
            }
            System.out.println(" Arquivo CSV salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println(" Erro ao salvar CSV: " + e.getMessage());
        }
    }

    // 2) LER TEXTO E MOSTRAR
    public static void lerCSV(String nomeArquivo) {
        System.out.println("\n Conteúdo lido do arquivo de texto:");
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println(" Erro ao ler CSV: " + e.getMessage());
        }
    }

    // 3) SALVAR OBJETOS EM .DAT (serializado)
    public static void salvarSerializado(List<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(financiamentos);
            System.out.println(" Arquivo serializado salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println(" Erro ao salvar serializado: " + e.getMessage());
        }
    }

    // 4) LER OBJETOS DO .DAT
    public static ArrayList<Financiamento> lerSerializado(String nomeArquivo) {
        ArrayList<Financiamento> lista = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (ArrayList<Financiamento>) in.readObject();
            System.out.println(" Arquivo serializado lido com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Erro ao ler serializado: " + e.getMessage());
        }
        return lista;
    }
}
