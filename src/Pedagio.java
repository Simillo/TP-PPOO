
import java.util.HashMap;
import java.util.List;

enum Veiculo {
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
}
