
enum EStatus {
    Morto,
    Grave,
    Ferimentos
}

/**
 * Classe Vitima.
 * Contém status.
 */
public class Vitima extends Pessoa{
    private EStatus _status;

    /**
     * Construtor do objeto.
     * @param status status da vítima.
     */
    public Vitima (String nome, String cpf, int idade, EStatus status) {
        super(nome,cpf,idade);
        this._status = status;
    }
}
