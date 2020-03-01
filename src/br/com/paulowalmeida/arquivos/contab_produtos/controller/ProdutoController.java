package br.com.paulowalmeida.arquivos.contab_produtos.controller;

import br.com.paulowalmeida.arquivos.contab_produtos.model.entities.FileProduto;
import br.com.paulowalmeida.arquivos.contab_produtos.model.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private FileProduto fileProduto = new FileProduto();
    private String diretorio;

    public ProdutoController(String diretorio) {
        this.diretorio = diretorio;
    }

    public void salvarDadosListaProdutos(String arquivoEntrada) {
        produtos = fileProduto.lerArquivo(diretorio, arquivoEntrada);
    }

    public void criarArquivoListaProdutos(String diretorioSaida, String nomeArquivo){
        boolean sucesso = fileProduto.criarArquivo(this.diretorio, diretorioSaida ,nomeArquivo, produtos);
        if (sucesso){
            System.out.println("Arquivo criado com sucesso:");
            System.out.println("Localização: " + this.diretorio + diretorioSaida);
            System.out.println("Nome do Arquivo: " + nomeArquivo);
        }
        else {
            System.out.println("Operação não pôde ser concluída.");
        }
    }

    @Override
    public String toString() {
        String informacao = "";
        for (Produto produto : produtos) {
            informacao += produto.toString();
        }
        return informacao;
    }
}