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

    public String get_nome() {
        return this._nome;
    }
    
    public void mostrarDados() {
    	System.out.println("Nome do funcion�rio: " + this._nome);
    	System.out.println("CPF do funcion�rio: " + this._cpf);
    	System.out.println("Idade do funcion�rio: " + this._idade);
    	System.out.println("Sal�rio do funcion�rio: " + this._salario);
    	System.out.println("Cargo do funcion�rio: " + this._cargo);
    }
}
