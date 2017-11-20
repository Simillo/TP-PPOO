
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
}
