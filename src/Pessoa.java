/**
 * Classe Pessoa.
 * Contém nome, cpf, idade.
 */
public class Pessoa {
    private String _nome;
    private String _cpf;
    private int _idade;

    /**
     * Construtor do objeto.
     * @param nome nome do funcionário.
     * @param cpf cpf do funcionário.
     * @param idade idade do funcionário.
     */
    public Pessoa (String nome, String cpf, int idade) {
        this._nome = nome;
        this._cpf = cpf;
        this._idade = idade;
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
}
