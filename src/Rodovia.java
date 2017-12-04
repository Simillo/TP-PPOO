import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe Rodovia.
 * Contém o nome, extensão (tamanho), lista de acidentes, empresa dona e lista de pedágios.
 */
public class Rodovia {
    private String _nome;
    private double _extensao;
    private List<Acidente> _acidentes = new ArrayList<Acidente>();
    private Empresa _empresa;
    private List<Pedagio> _pedagios = new ArrayList<Pedagio>();

    /**
     * Construtor do objeto.
     * @param nome nome da rodovia.
     * @param extensao extensão da rodovia.
     * @param empresa empresa dona.
     */
    public Rodovia (String nome, double extensao, Empresa empresa) {
        this._nome = nome;
        this._extensao = extensao;
        this._empresa = empresa;
    }

    /**
     * Método para adicionar um novo acidente a rodovia.
     * @param acidente um objeto Acidente com a ocorrência.
     */
    public void aumentarAcidentes (Acidente acidente) {
        this._acidentes.add(acidente);
    }

    /**
     * Método para adicionar um pedágio a rodovia.
     * @param pedagio objeto Pedagio com a localização (km) e os valores.
     */
    public void addPedagio (Pedagio pedagio) {
        this._pedagios.add(pedagio);
    }

    /**
     * Método get do nome da rodovia.
     * @return o nome da rodovia.
     */
    public String get_nome() {
        return this._nome;
    }

    /**
     * Método para imprimir os dados da rodovia para o usuário.
     */
    public void mostrarDados() {
    	System.out.println("Nome da rodovia: " + this._nome);
    	System.out.println("Extensão da rodovia: " + this._extensao);
    	System.out.println("Empresa dona da rodovia: "+ this._empresa.get_nome());
    	this._acidentes.forEach(a -> {
    		a.mostrarDados();
    	});
    	this._pedagios.forEach(p -> {
    		p.mostrarDados();
    	});
    	
    }

    /**
     * Método para imprimir os dados dos pedágios da rodovia.
     */
    public void listarPedagios () {
        this._pedagios.forEach(p -> {
            p.mostrarDados();
        });
    }
}
