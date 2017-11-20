import com.sun.jndi.toolkit.ctx.AtomicDirContext;
import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Empresa> empresas = new ArrayList<Empresa>();
        List<Rodovia> rodovias = new ArrayList<Rodovia>();
        String op;
        int index;
        boolean flagSystem = false;
        while(!flagSystem) {
            if (empresas.size() == 0) {
                System.out.println("Cadastre uma Empresa:");
                System.out.println("Nome:");
                String nomeEmpresa = sc.nextLine();
                Empresa novaEmpresa = new Empresa(nomeEmpresa);
                empresas.add(novaEmpresa);
                System.out.println(nomeEmpresa + " cadastrada com sucesso!");
            } else {
                System.out.println("(a) Adicionar uma empresa:");
                System.out.println("(r) Adicionar uma rodovia:");
                System.out.println("(c) Adicionar um acidente:");
                System.out.println("(s) Para selecionar uma empresa:");
                op = sc.next();
                Empresa empresaTemp = null;
                Rodovia rodoviaTemp = null;
                Acidente acidenteTemp = null;
                switch (op) {
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
                        int contador = 1;
                        for (int i = 0; i < empresas.size(); i++) {
                            System.out.println("(" + (i + 1) + ")" + " empresa " + empresas.get(i).get_nome());
                        }
                        index = sc.nextInt();
                        if (index > empresas.size() || index <= 0) {
                            System.out.println("Opção inválida!");
                        } else {
                            empresaTemp = empresas.get(index - 1);
                            System.out.println("(a) Adicionar funcionário;");
                            System.out.println("(d) demitir funcionário;");
                            op = sc.next();
                            Funcionario funcTemp = null;
                            switch (op) {
                                case "a":
                                    funcTemp = addFuncionario();
                                    empresaTemp.addFuncionario(funcTemp);
                                    System.out.println(funcTemp.get_nome() + " cadastrado com sucesso!");
                                    break;
                                case "d":
                                    System.out.println("Digite o CPF do funcionário a ser demitido:");
                                    String demitirCPF = sc.nextLine();
                                    funcTemp = empresaTemp.demitirFuncionario(demitirCPF);
                                    System.out.println(funcTemp.get_nome() + " demitido com sucesso!");
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

    public static Funcionario addFuncionario () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do funcionário:");
        String nome = sc.nextLine();
        System.out.println("CPF do funcionário:");
        String cpf = sc.nextLine();
        System.out.println("Idade do funcionário:");
        int idade = sc.nextInt();
        System.out.println("Salário do funcionário:");
        double salario = sc.nextDouble();
        System.out.println("Cargo do funcionário:");
        String cargo = sc.nextLine();
        return new Funcionario(nome, cpf, idade, salario, cargo);
    }

    public static Empresa addEmpresa () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da empresa:");
        String nome = sc.nextLine();
        return new Empresa(nome);
    }

    public static Rodovia addRodovia(List<Empresa> empresas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da rodovida:");
        String nome = sc.nextLine();
        System.out.println("Extensão da rodovia:");
        double extensao = sc.nextDouble();
        System.out.println("Selecione uma das empresas cadastradas:");
        int index = -1;
        while (index <= 0 || index > empresas.size()) {
            for (int i = 0; i < empresas.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + " empresa " + empresas.get(i).get_nome());
            }
            index = sc.nextInt();
            if (index <= 0 || index > empresas.size()) {
                System.out.println("Empresa inválida!");
            }
        }
        return new Rodovia(nome, extensao, empresas.get(index - 1));
    }

    public static Acidente addAcidente() {
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

    public static Rodovia selecionarRodovia(List<Rodovia> rodovias) {
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
