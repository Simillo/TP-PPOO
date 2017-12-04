import java.util.ArrayList;
import java.util.List;

/**
 * Classe do objeto Empresa.
 * Possui o nome da empresa e uma lista de funcionários.
 */
public class Empresa {

    private String _nome;
    private List<Funcionario> _funcionarios = new ArrayList<Funcionario>();

    /**
     * Construtor do objeto.
     * @param nome nome da empresa.
     */
    public Empresa (String nome) {
        this._nome = nome;
    }

    /**
     * Método para adição de um funcionário a lista de funcionários da empresa.
     * @param funcionario objeto Funcionário.
     */
    public void addFuncionario (Funcionario funcionario) {
        this._funcionarios.add(funcionario);
    }

    /**
     * Método para demitir um funcionário (excluir).
     * @param cpf cpf do funcionário a ser demitido.
     * @return o objeto Funcionario que foi demitido (nulo se não existir).
     */
    public Funcionario demitirFuncionario (String cpf) {
        Funcionario funcionarioTemp = _funcionarios.stream()
                                      .filter(f -> f.get_cpf()
                                      .equals(cpf))
                                      .findFirst()
                                      .get();
        _funcionarios.remove(funcionarioTemp);
        return funcionarioTemp;
    }

    /**
     * Método get do nome da empresa.
     * @return o nome da empresa.
     */
    public String get_nome() {
        return this._nome;
    }

    /**
     * Método de impressão dos dados da empresa para o usuário.
     */
    public void mostrarDados() {
    	System.out.println("Nome da empresa: " + this._nome);
    	System.out.println("---Funcionários---");
    	this._funcionarios.forEach(f -> {
    		f.mostrarDados();
    	});
    }
}
