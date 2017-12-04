import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
/**
 * Classe MAIN
 */
public class Main {

    /**
     * Metódo main
     * @param args argumentos opcionais.
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Empresa> empresas = new ArrayList<Empresa>();
        List<Rodovia> rodovias = new ArrayList<Rodovia>();
        int index;
        boolean flagSystem = false;
        while(!flagSystem) {
            String op;
            if (empresas.size() == 0) {
                System.out.println("Cadastre uma Empresa:");
                System.out.println("Nome da empresa:");
                String nomeEmpresa = sc.nextLine();
                Empresa novaEmpresa = new Empresa(nomeEmpresa);
                empresas.add(novaEmpresa);
                System.out.println(nomeEmpresa + " cadastrada com sucesso!");
            } else {
                System.out.println("(a) Adicionar uma empresa:");
                System.out.println("(r) Adicionar uma rodovia:");
                System.out.println("(c) Adicionar um acidente:");
                System.out.println("(p) Adicionar um pedgio:");
                System.out.println("(le) Listar empresas:");
                System.out.println("(lr) Listar rodovias:");
                System.out.println("(lp) Listar pedágios:");
                System.out.println("(s) Para selecionar uma empresa:");
                op = sc.nextLine();
                Empresa empresaTemp = null;
                Rodovia rodoviaTemp = null;
                Acidente acidenteTemp = null;
                Funcionario funcionarioTemp = null;
                Pedagio pedagioTemp = null;
                switch (op) {
                	case "le":
                		if (empresas.size() == 0) {
                			System.out.println("Nenhuma empresa cadastrada!");
                		} else {
                			empresas.forEach(e -> {
                				e.mostrarDados();
                				System.out.println("\n-------\n");
                			});
                		}
                		break;
                	case "lr":
                		if (rodovias.size() == 0) {
                			System.out.println("Nenhuma rodovia cadastrada!");
                		} else {
                			rodovias.forEach(r -> {
                				r.mostrarDados();
                			});
                		}
                		break;
                    case "lp":
                        if (rodovias.size() == 0) {
                            System.out.println("É necessário adicionar ao menos uma rodovia!");
                        } else {
                            rodoviaTemp = selecionarRodovia(rodovias);
                            rodoviaTemp.listarPedagios();
                        }
                        break;
                    case "p":
                        if (rodovias.size() == 0) {
                            System.out.println("É necessário adiconar ao menos uma rodovia!");
                        } else {
                            pedagioTemp = addPedagio();
                            rodoviaTemp = selecionarRodovia(rodovias);
                            rodoviaTemp.addPedagio(pedagioTemp);
                            System.out.println("Pedágio adicionado com sucesso!");
                        }
                        break;
                    case "c":
                        if (rodovias.size() != 0) {
                            acidenteTemp = addAcidente();
                            rodoviaTemp = selecionarRodovia(rodovias);
                            rodoviaTemp.aumentarAcidentes(acidenteTemp);
                            System.out.println("Acidente adicionado com sucesso!");
                        } else {
                            System.out.println("É necessário adicionar ao menos uma rodovia!");
                        }
                        break;
                    case "a":
                        empresaTemp = addEmpresa();
                        empresas.add(empresaTemp);
                        System.out.println(empresaTemp.get_nome() + " adicionada com sucesso!");
                        break;
                    case "r":
                        rodoviaTemp = addRodovia(empresas);
                        rodovias.add(rodoviaTemp);
                        break;
                    case "s":
                        for (int i = 0; i < empresas.size(); i++) {
                            System.out.println("(" + (i + 1) + ")" + " empresa " + empresas.get(i).get_nome());
                        }
                        index = sc.nextInt();
                        if (index > empresas.size() || index <= 0) {
                            System.out.println("Empresa inválida!");
                        } else {
                            empresaTemp = empresas.get(index - 1);
                            System.out.println("(a) Adicionar funcionário;");
                            System.out.println("(d) Demitir funcionário;");
                            op = sc.next();
                            switch (op) {
                                case "l":
                                    break;
                                case "a":
                                    funcionarioTemp = addFuncionario();
                                    empresaTemp.addFuncionario(funcionarioTemp);
                                    System.out.println(funcionarioTemp.get_nome() + " cadastrado com sucesso!");
                                    break;
                                case "d":
                                    System.out.println("Digite o CPF do funcionário a ser demitido:");
                                    String cpfTemp = promptCpf();
                                    funcionarioTemp = empresaTemp.demitirFuncionario(cpfTemp);
                                    System.out.println(funcionarioTemp.get_nome() + " demitido com sucesso!");
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static String promptCpf() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CPF do funcionpario a ser demitido:");
        return sc.nextLine();
    }

    /**
     * Método UI para adicionar um funcionário.
     * @return um objeto Funcionario criado.
     */
    private static Funcionario addFuncionario () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do funcionário:");
        String nome = sc.nextLine();
        System.out.println("Cargo do funcionário:");
        String cargo = sc.nextLine();
        System.out.println("CPF do funcionário:");
        String cpf = sc.nextLine();
        System.out.println("Idade do funcionário:");
        int idade = sc.nextInt();
        System.out.println("Salário do funcionário:");
        double salario = sc.nextDouble();
        return new Funcionario(nome, cpf, idade, salario, cargo);
    }

    /**
     * Método UI para adicionar uma empresa.
     * @return um objeto Empresa criado.
     */
    private static Empresa addEmpresa () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da empresa:");
        String nome = sc.nextLine();
        return new Empresa(nome);
    }

    /**
     * Método UI para adicionar uma rodovia.
     * @param empresas Lista de empresas cadastradas.
     * @return um objeto Rodovia criado.
     */
    private static Rodovia addRodovia(List<Empresa> empresas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da rodovida:");
        String nome = sc.nextLine();
        System.out.println("Extensão da rodovia:");
        double extensao = sc.nextDouble();
        System.out.println("Selecione uma das empresas cadastradas:");
        int index = -1;
        while (index < 0 || index >= empresas.size()) {
            for (int i = 0; i < empresas.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + " empresa " + empresas.get(i).get_nome());
            }
            index = sc.nextInt();
            if (index <= 0 || index > empresas.size()) {
                System.out.println("Empresa inválida!");
            }
        }
        return new Rodovia(nome, extensao, empresas.get(index));
    }

    /**
     * Método UI para adicionar um acidente.
     * @return um objeto Acidente criado.
     */

    private static Acidente addAcidente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantidade de mortos:");
        int mortos = sc.nextInt();
        System.out.println("Quanditade de feridos:");
        int feridos = sc.nextInt();
        System.out.println("Descrição do acidente:");
        String descricao = sc.nextLine();
        System.out.println("Data do início do acidente (formato \"dd/mm/yyyy\"):");
        String dataInicioS = sc.nextLine();
        System.out.println("Data do fim do acidente e liberação do trecho (formato \"dd/mm/yyyy\"):");
        String dataFimS = sc.nextLine();
        DateFormat dataFormato = DateFormat.getInstance();
        Date dataInicio = null;
        Date dataFim = null;
        try {
            dataInicio = dataFormato.parse(dataInicioS);
            dataFim = dataFormato.parse(dataFimS);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return new Acidente(feridos, mortos, descricao, dataInicio, dataFim);
    }

    /**
     * Método UI para adicionar um pédagio.
     * @return um objeto Pedágio criado.
     */

    private static Pedagio addPedagio() {
        Scanner sc = new Scanner(System.in);
        HashMap hashPedagio = new HashMap();
        System.out.println("KM do pedágio");
        int km = sc.nextInt();
        System.out.println("Digite os valores:");
        EVeiculo veiculo[] = {EVeiculo.MOTO, EVeiculo.CARRO, EVeiculo.PICKUP, EVeiculo.CAMINHAO};
        String veiculoNome[] = {"moto", "carro", "pickup", "caminhão"};
        double valores[] = new double[4];
        for(int i = 0; i < 4; ++i) {
            System.out.println("Preço do pedágio para " + veiculoNome[i] + ":");
            double valor = sc.nextDouble();
            hashPedagio.put(veiculo[i], valor);
        }
        return new Pedagio(km, hashPedagio);
    }

    /**
     * Método UI para selecionar uma rodovia.
     * @param rodovias Lista de rodovias cadastradas.
     * @return a rodovia selecionada.
     */

    private static Rodovia selecionarRodovia(List<Rodovia> rodovias) {
        Scanner sc = new Scanner(System.in);
        int index = -1;
        while (index <= 0 || index > rodovias.size()) {
            for (int i = 0; i < rodovias.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + " rodovia " + rodovias.get(i).get_nome());
            }
            index = sc.nextInt();
            if (index <= 0 || index > rodovias.size()) {
                System.out.println("Empresa inválida!");
            }
        }
        return rodovias.get(index - 1);
    }
}
