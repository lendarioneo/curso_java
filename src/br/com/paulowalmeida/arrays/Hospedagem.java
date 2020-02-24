package br.com.paulowalmeida.arrays;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Hospedagem {
    public static void main(String[] args) {
        Estudante[] estudantes = new Estudante[10];
        int n = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade de estudantes se hospedará?"));
        for (int i = 0; i < n; i++) {
            String nome = JOptionPane.showInputDialog("#"+(i+1) + "\nQual o nome do estudante?");
            String email = JOptionPane.showInputDialog("#"+(i+1) + "\nQual o email?");
            int quarto = Integer.parseInt(JOptionPane.showInputDialog("#"+(i+1) + "\nQual o quarto escolhido?"));
            estudantes[quarto] = new Estudante(nome, email);
        }

        String msg = "Busy Rooms:";
        for (int i = 0; i < estudantes.length ; i++) {
            if (estudantes[i] != null){
                msg += "\n" + i + ": " + estudantes[i].getNome() + ", " + estudantes[i].getEmail();
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}