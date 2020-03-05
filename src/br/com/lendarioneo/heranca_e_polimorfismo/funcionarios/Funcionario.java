package br.com.lendarioneo.heranca_e_polimorfismo.funcionarios;

public class Funcionario {
    protected String nome;
    protected int horas;
    protected double valorHora;

    public Funcionario(String nome, int horas, double valorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public Funcionario() {
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public double pagamento(){
        return horas * valorHora;
    }
}
