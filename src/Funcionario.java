/**
 * Classe Funcionario.
 * Contém nome, cpf, idade, salário e o cargo.
 */
public class Funcionario {
    private String _nome;
    private String _cpf;
    private int _idade;
    private double _salario;
    private String _cargo;

    /**
     * Construtor do objeto.
     * @param nome nome do funcionário.
     * @param cpf cpf do funcionário.
     * @param idade idade do funcionário.
     * @param salario salário do funcionário.
     * @param cargo cargo do funcionário.
     */
    public Funcionario (String nome, String cpf, int idade, double salario, String cargo) {
        this._nome = nome;
        this._cpf = cpf;
        this._idade = idade;
        this._salario = salario;
        this._cargo = cargo;
    }

    /**
     * Método get do cpf do funcionário.
     * @return o cpf do funcionário
     */
    public String get_cpf() {
        return this._cpf;
    }

    /**
     * Método get do nome do funcionário.
     * @return o nome do funcionário.
     */
    public String get_nome() {
        return this._nome;
    }

    /**
     * Método para impressão dos dados do funcionário.
     */
    public void mostrarDados() {
    	System.out.println("Nome do funcionário: " + this._nome);
    	System.out.println("CPF do funcionário: " + this._cpf);
    	System.out.println("Idade do funcionário: " + this._idade);
    	System.out.println("Sal�rio do funcionário: " + this._salario);
    	System.out.println("Cargo do funcionário: " + this._cargo);
    }
}
