package br.com.lendarioneo.arquivos.contab_produtos.model.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProduto {


    public List<Produto> lerArquivo(String diretorio, String arquivoEntrada) {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(diretorio + arquivoEntrada))) {
            String linha = reader.readLine();
            while (linha != null) {
                String[] atributosProduto = linha.split(",");
                Produto produto = gerarProduto(atributosProduto);
                produtos.add(produto);
                linha = reader.readLine();
            }
        } catch (IOException p) {
            System.out.println(p.getMessage());
            System.exit(0);
        }
        return produtos;
    }

    public boolean criarArquivo(String diretorioRaiz, String diretorioSaida, String arquivoSaida, List<Produto> produtos) {
        String novoDiretorio = diretorioRaiz + diretorioSaida;
        boolean criouDiretorio = criarDiretorio(novoDiretorio);

        if (!criouDiretorio) {
            return false;
        }

        else {
            String pathArquivo = diretorioRaiz + diretorioSaida + "\\" + arquivoSaida;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathArquivo))) {
                for (Produto produto : produtos) {
                    writer.write(produto.getNome() + "," + produto.calcularTotal());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }
    }

    private Produto gerarProduto(String[] produtoCampo) {
        String nomeProduto = produtoCampo[0];
        double valorProduto = Double.parseDouble(produtoCampo[1]);
        int quantidadeProduto = Integer.parseInt(produtoCampo[2]);

        return new Produto(nomeProduto, valorProduto, quantidadeProduto);
    }

    private boolean criarDiretorio(String novoDiretorio) {
        /*Se diretorio não existe, então criar...*/
        boolean criouDiretorio = false;
        if (new File(novoDiretorio).exists())
            return true;
        else
            return new File(novoDiretorio).mkdir();
    }
}
