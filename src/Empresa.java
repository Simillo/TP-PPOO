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
}
