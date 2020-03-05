package br.com.lendarioneo.heranca_e_polimorfismo.produtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private int quantidadeProdutos = 0;

    public void setQuantidadeProdutos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qual a quantidade de produtos deseja registrar? ");
        this.quantidadeProdutos = scanner.nextInt();
    }

    public void informarProdutos() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.print("Qual o nome do produto? ");
            String nome = scanner.nextLine();

            System.out.print("Qual o preço do produto? ");
            double preco = scanner.nextDouble();

            System.out.print("Qual o tipo do produto? (1-Importado/2-Usado): ");
            int tipoProduto = scanner.nextInt();
            scanner.nextLine();

            if (tipoProduto == 1) {
                System.out.print("Qual a taxa da alfândega? ");
                double taxaAlfandega = scanner.nextDouble();
                produtos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
                scanner.nextLine();
            }

            else {
                System.out.print("Qual a data de Fabricação? ");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
                Date dateFabricacao = null;

                try {
                    dateFabricacao = simpleDateFormat.parse(scanner.nextLine());
                }

                catch (ParseException e) {
                    e.printStackTrace();
                }
                produtos.add(new ProdutoUsado(nome, preco, dateFabricacao));
            }
        }
    }

    public void exibirEtiquetas(){
        for (Produto produto: produtos) {
            System.out.print(produto.gerarEtiquetaPreco());
            System.out.println("\n");
        }
    }

    public void executar(){
        this.setQuantidadeProdutos();
        this.informarProdutos();
        this.exibirEtiquetas();
    }
}
