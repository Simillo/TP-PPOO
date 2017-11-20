import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String _nome;
    private List<Funcionario> _funcionarios = new ArrayList<Funcionario>();

    public Empresa (String nome) {
        this._nome = nome;
    }

    public void addFuncionario (Funcionario funcionario) {
        this._funcionarios.add(funcionario);
    }

    public Funcionario demitirFuncionario (String cpf) {
        Funcionario funcionarioTemp = _funcionarios.stream()
                                      .filter(f -> f.get_cpf()
                                      .equals(cpf))
                                      .findFirst()
                                      .get();
        _funcionarios.remove(funcionarioTemp);
        return funcionarioTemp;
    }

    public String get_nome() {
        return this._nome;
    }
    
    public void mostrarDados() {
    	System.out.println("Nome da empresa: " + this._nome);
    	System.out.println("---Funcionários---");
    	this._funcionarios.forEach(f -> {
    		f.mostrarDados();
    	});
    }
}
