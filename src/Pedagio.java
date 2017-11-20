
import java.util.HashMap;

enum EVeiculo {
    MOTO,
    CARRO,
    PICKUP,
    CAMINHAO
}

public class Pedagio {
    private int _km;
    private HashMap _valores;

    public Pedagio (int km, HashMap valores) {
        this._km = km;
        this._valores = valores;
    }

    public int get_km() {
        return this._km;
    }

    public HashMap get_valores() {
        return this._valores;
    }
    
    public void mostrarDados() {
    	System.out.println("KM do pedágio:" + this._km);
    	System.out.println("Valor para moto: " + this._valores.get(EVeiculo.MOTO));
    	System.out.println("Valor para carro: "+ this._valores.get(EVeiculo.CARRO));
    	System.out.println("Valor para pickup: "+ this._valores.get(EVeiculo.PICKUP));
    	System.out.println("Valor para caminhão: "+ this._valores.get(EVeiculo.CAMINHAO));
    }
}
