package br.com.lendarioneo.hascode_e_equals.view;

import br.com.lendarioneo.hascode_e_equals.model.Cliente;

public class Programa {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Maria", "maria@gmail.com");
        Cliente cliente2 = new Cliente("Pedro", "pedro@gmail.com");
        Cliente cliente3 = new Cliente("Maria", "maria@gmail.com");

        System.out.println(cliente1.hashCode());
        System.out.println(cliente2.hashCode());
        System.out.println(cliente3.hashCode());
        System.out.println(cliente1.equals(cliente3));
    }
}
