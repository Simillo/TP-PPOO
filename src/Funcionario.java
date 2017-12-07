/**
 * Classe Funcionario.
 * Contém salário e o cargo.
 */
public class Funcionario extends Pessoa{
    private double _salario;
    private String _cargo;

    /**
     * Construtor do objeto.
     * @param nome nome do funcionário.
     * @param cpf cpf do funcionário.
     * @param idade salário do funcionario.
     * @param salario salário do funcionário.
     * @param cargo cargo do funcionário.
     */
    public Funcionario (String nome, String cpf, int idade, double salario, String cargo) {
        super(nome,cpf,idade);
        this._salario = salario;
        this._cargo = cargo;
    }

    /**
     * Método para impressão dos dados do funcionário.
     */
    public void mostrarDados() {
    	System.out.println("Salário do funcionário: " + this._salario);
    	System.out.println("Cargo do funcionário: " + this._cargo);
    }
}
