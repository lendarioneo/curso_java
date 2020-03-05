package br.com.lendarioneo.heranca_e_polimorfismo.funcionarios;

public class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horas, double valorHora, double despesaAdicional) {
        super(nome, horas, valorHora);
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public double pagamento() {
        return (valorHora * horas) + (despesaAdicional * 110 / 100);
    }
}
