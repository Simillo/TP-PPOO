import java.util.Date;

public class Acidente {
    private int _feridos;
    private int _mortos;
    private String _descricao;
    private Date _inicio;
    private Date _fim;

    public Acidente (int feridos,  int mortos, String descricao, Date inicio, Date fim) {
        this._feridos = feridos;
        this._mortos = mortos;
        this._descricao = descricao;
        this._inicio = inicio;
        this._fim = fim;
    }
    
    public void mostrarDados() {
    	System.out.println("Quantidade de feridos: " + this._feridos);
    	System.out.println("Quantidade de mortos: " + this._mortos);
    	System.out.println("Descrição do acidente: " + this._descricao);
    	System.out.println("Data de início do acidente: "+ this._inicio);
    	System.out.println("Data do fim do acidente: " + this._fim);
    }
}
