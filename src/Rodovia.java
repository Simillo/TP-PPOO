import java.util.ArrayList;
import java.util.List;

public class Rodovia {
    private String _nome;
    private double _extensao;
    private List<Acidente> _acidentes;
    private Empresa _empresa;
    private List<Pedagio> _pedagios;

    public Rodovia (String nome, double extensao, Empresa empresa) {
        this._nome = nome;
        this._extensao = extensao;
        this._empresa = empresa;
        this._acidentes = new ArrayList<Acidente>();
        this._pedagios = new ArrayList<Pedagio>();
    }

    public void set_extensao(double _extensao) {
        this._extensao = _extensao;
    }

    public void aumentarAcidentes (Acidente acidente) {
        this._acidentes.add(acidente);
    }

    public void addPedagio (Pedagio pedagio) {
        this._pedagios.add(pedagio);
    }
}
