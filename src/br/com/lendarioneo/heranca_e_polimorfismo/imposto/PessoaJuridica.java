package br.com.lendarioneo.heranca_e_polimorfismo.imposto;

public class PessoaJuridica extends Pessoa {
    private int numeroFuncionarios;

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calcularImposto() {
        double ir = 0.0;
        if (numeroFuncionarios > 10){
            ir = rendaAnual * 14 / 100;
        }
        else {
            ir = rendaAnual * 16 / 100;
        }
        return ir;
    }
}
