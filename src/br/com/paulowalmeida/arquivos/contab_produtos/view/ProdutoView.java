package br.com.paulowalmeida.arquivos.contab_produtos.view;

import br.com.paulowalmeida.arquivos.contab_produtos.controller.ProdutoController;

import java.util.Scanner;

public class ProdutoView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoController produtoController = new ProdutoController("c:\\temp\\");

        System.out.print("Informe o nome do arquivo: ");
        String arquivoEntrada = scanner.nextLine();
        produtoController.salvarDadosListaProdutos(arquivoEntrada);

        System.out.println("Informações dos Produtos:");
        System.out.println(produtoController.toString());

        System.out.print("Informe o diretorio de saida do arquivo: ");
        String pathOut = scanner.nextLine();

        System.out.print("Qual o nome do arquivo que deseja salvar as informações dos produtos: ");
        String nome = scanner.nextLine();
        produtoController.criarArquivoListaProdutos(pathOut, nome);

        System.out.println("Fim do programa.");
    }
}
