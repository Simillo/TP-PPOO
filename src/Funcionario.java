public class Funcionario {
    private String _nome;
    private String _cpf;
    private int _idade;
    private double _salario;
    private String _cargo;

    public Funcionario (String nome, String cpf, int idade, double salario, String cargo) {
        this._nome = nome;
        this._cpf = cpf;
        this._idade = idade;
        this._salario = salario;
        this._cargo = cargo;
    }

    public String get_cpf() {
        return this._cpf;
    }
}
