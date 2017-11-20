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
}
