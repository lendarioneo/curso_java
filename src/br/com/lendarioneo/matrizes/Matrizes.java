package br.com.lendarioneo.matrizes;

import java.util.Scanner;

public class Matrizes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de N: ");
        int n = scanner.nextInt();

        System.out.print("Digite o valor de M: ");
        int m = scanner.nextInt();

        int[][] matriz = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Digite o valor da posição #" + (i + 1) + (j + 1) + ": ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        /*Mostrar a matriz gerada*/
        String matrizFormatada = "";


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String ij = "";

                if (matriz[i][j] < -10) {
                    matrizFormatada += "-" + matriz[i][j];
                } else if (matriz[i][j] > -10 && matriz[i][j] < 0) {
                    matrizFormatada += "-0" + matriz[i][j];
                } else if (matriz[i][j] > 0 && matriz[i][j] < 10) {
                    matrizFormatada += "0" + matriz[i][j];
                } else {
                    matrizFormatada += matriz[i][j] + "";
                }

                if (j == (m - 1)) {
                    matrizFormatada += "\n";
                } else {
                    matrizFormatada += " ";
                }
            }
        }
        System.out.print(matrizFormatada);

        System.out.print("Digite um numero da matriz: ");
        int numeroEscolhido = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == numeroEscolhido) {
                    System.out.println("Numero acima: " + matriz[i - 1][j]);
                    System.out.println("Numero a esquerda: " + matriz[i][j - 1]);
                    System.out.println("Numero abaixo: " + matriz[i + 1][j]);
                    System.out.println("Numero a direita: " + matriz[i][j + 1]);
                }
            }
        }
    }
}
