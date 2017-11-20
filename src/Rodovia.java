import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rodovia {
    private String _nome;
    private double _extensao;
    private List<Acidente> _acidentes = new ArrayList<Acidente>();
    private Empresa _empresa;
    private List<Pedagio> _pedagios = new ArrayList<Pedagio>();

    public Rodovia (String nome, double extensao, Empresa empresa) {
        this._nome = nome;
        this._extensao = extensao;
        this._empresa = empresa;
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

    public String get_nome() {
        return this._nome;
    }

    public void listarPedagios () {
        this._pedagios.forEach(p -> {
            System.out.println(p.get_km() + ":");
            final HashMap valores = p.get_valores();
            System.out.println("Moto: " + valores.get(EVeiculo.MOTO));
            System.out.println("Carro: " + valores.get(EVeiculo.CARRO));
            System.out.println("Pickup: " + valores.get(EVeiculo.PICKUP));
            System.out.println("Caminhao: " + valores.get(EVeiculo.CAMINHAO));
        });
    }
}
