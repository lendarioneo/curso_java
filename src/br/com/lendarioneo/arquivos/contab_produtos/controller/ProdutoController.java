package br.com.lendarioneo.arquivos.contab_produtos.controller;

import br.com.lendarioneo.arquivos.contab_produtos.model.entities.FileProduto;
import br.com.lendarioneo.arquivos.contab_produtos.model.entities.Produto;

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
        this.produtos = fileProduto.lerArquivo(this.diretorio, arquivoEntrada);
    }

    public void criarArquivoListaProdutos(String diretorioSaida, String nomeArquivo){
        boolean sucesso = this.fileProduto.criarArquivo(this.diretorio, diretorioSaida ,nomeArquivo, this.produtos);
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
        for (Produto produto : this.produtos) {
            informacao += produto.toString();
        }
        return informacao;
    }
}