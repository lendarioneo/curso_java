package br.com.lendarioneo.heranca_e_polimorfismo.imposto;

public class PessoaFisica extends Pessoa {

    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calcularImposto(){
       double ir = (rendaAnual < 20000 ? rendaAnual * 15.0 / 100.0 : rendaAnual * 25.0 / 100.0);
       double saude = (gastosSaude > 0.0 ? gastosSaude * 50.0 / 100.0 : 0.0);
       return ir - saude;
    }
}

//5.200
//4.240
//
//
//14.300
//8.300
