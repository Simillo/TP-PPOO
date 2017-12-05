
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

    public void mostrarDados() {
        System.out.println("Nome da vítima: "+ this.get_nome());
        System.out.println("CPF da vítima: "+ this.get_nome());
        System.out.println("Idade da vítima: "+ this.get_nome());
        switch (_status) {
            case Morto:
                System.out.println("Vítima faleceu.");
                break;
            case Grave:
                System.out.println("Vítima está em estado grave.");
                break;
            case Ferimentos:
                System.out.println("Vítima teve leve ferimentos.");
                break;
            default:
                break;

        }
        System.out.println("Idade da vítima: "+ this.get_nome());
    }
}
