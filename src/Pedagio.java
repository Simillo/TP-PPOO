
import java.util.HashMap;

/**
 * Classe do Pedágio.
 * Contém km (km da rodovia (localização)) e valores do pedágio.
 */

/**
 * Enum EVeiculo.
 * Moto, carro, pickup e caminhão.
 */
enum EVeiculo {
    MOTO,
    CARRO,
    PICKUP,
    CAMINHAO
}

public class Pedagio {
    private int _km;
    private HashMap _valores;

    /**
     * Construtor do pedágio.
     * @param km localização em KM do pedágio.
     * @param valores HashMap dos valores com o enum como KEY.
     */
    public Pedagio (int km, HashMap valores) {
        this._km = km;
        this._valores = valores;
    }

    /**
     * Método get do KM do pedágio.
     * @return o KM do pedágio.
     */
    public int get_km() {
        return this._km;
    }

    /**
     * Método get dos valores do pedágio.
     * @return um HashMap dos valores do pedágio.
     */
    public HashMap get_valores() {
        return this._valores;
    }

    /**
     * Método para imprimir os dados do pedágio para o usuário.
     */
    public void mostrarDados() {
    	System.out.println("KM do pedágio:" + this._km);
    	System.out.println("Valor para moto: " + this._valores.get(EVeiculo.MOTO));
    	System.out.println("Valor para carro: "+ this._valores.get(EVeiculo.CARRO));
    	System.out.println("Valor para pickup: "+ this._valores.get(EVeiculo.PICKUP));
    	System.out.println("Valor para caminhão: "+ this._valores.get(EVeiculo.CAMINHAO));
    }
}
