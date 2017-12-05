import java.util.ArrayList;
import java.util.List;

/**
 * Class do objeto Acidente.
 */
public class Acidente {
    private int _qntVitimas;
    private List<Vitima> _vitimas = new ArrayList<Vitima>();
    private String _descricao;
    private String _inicio;
    private String _fim;

    /**
     * Construtor do objeto.
     * @param qntVitimas quantidade de vítimas.
     * @param descricao descrição do acidente.
     * @param inicio data início do acidente.
     * @param fim data fim do acidente.
     */
    public Acidente (int qntVitimas, String descricao, String inicio, String fim, List<Vitima> vitimas) {
        this._qntVitimas = qntVitimas;
        this._descricao = descricao;
        this._inicio = inicio;
        this._fim = fim;
        this._vitimas = vitimas;
    }

    /**
     * Método para imprimir os dados do objeto para o usuário.
     */
    public void mostrarDados() {
    	System.out.println("Quantidade de vítimas: " + this._qntVitimas);
    	if (_qntVitimas > 0) {
    	    System.out.println("------ Dados das vítimas ------");
    	    _vitimas.forEach(v ->{
    	        v.mostrarDados();
                System.out.println("------------");
            });
        }
    	System.out.println("Descrição do acidente: " + this._descricao);
    	System.out.println("Data de início do acidente: "+ this._inicio);
    	System.out.println("Data do fim do acidente: " + this._fim);
    }
}
