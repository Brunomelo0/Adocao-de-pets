/**
 * Classe responsável pelas janelas de interação com o usuário
 * @author Bruno Melo
 */
package SistemaDeAdocao.Servicos;

import java.util.Scanner;

public class Menu {

    /**
     * Método que contém o menu principal do sistema
     * É por ele que são acessadas com todas as outras janelas.
     * 
     * @param adocao
     */
    public static void janelas(Adocao adocao) {
        Scanner scan = new Scanner(System.in);
        String opcao;
        do {
            System.out.println();
            System.out.println("* Menu de adoção *");
            System.out.println();
            System.out.println("1) Registrar");
            System.out.println("2) Acessar conta");
            System.out.println("3) Sair");
            opcao = scan.next();
            System.out.println();
            if (opcao.equals("1"))
                menuRegistrar(adocao);
            else if (opcao.equals("2"))
                menuLogin(adocao);
            else if (opcao.equals("3")) {
                Dados.deleteAll("pets.txt");
                Dados.deleteAll("nextIdPet.txt");
                break;
            } else
                System.out.println("Comando inválido!");
        } while (true);
        scan.close();

    }

    /**
     * Método responsável pela janela de Cadastro no sistema.
     * 
     * @param adocao
     */
    private static void menuRegistrar(Adocao adocao) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println();
        System.out.println("* Menu de cadastro *");
        System.out.print("-> Nome: ");
        String nome = scan1.nextLine();
        System.out.print("\n-> Idade: ");
        int idade = scan1.nextInt();
        System.out.print("\n-> Endereço: ");
        String endereco = scan1.next();
        System.out.println();

        System.out.println("Conta criada com sucesso!");
        System.out.println("Seu Id para acessar a conta é: " + Dados.readId("nextId.txt"));

        adocao.addCliente(new Cliente(nome, idade, endereco, Dados.readId("nextId.txt")));

        System.out.println();

    }

    /**
     * Método responsável pela janela de Login e que abre
     * a janela de menu do cliente.
     * 
     * @param adocao
     */
    private static void menuLogin(Adocao adocao) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("* Login *");
        System.out.print("-> Nome: ");
        String nome = scan2.nextLine();
        System.out.print("\n-> Id: ");
        int id = scan2.nextInt();
        System.out.println();

        if (adocao.encontrarCliente(nome, id) == true) {
            menuCliente(adocao, nome);
        } else
            System.out.println("Nome de usuario ou id incorretos");

    }

    /**
     * Método responsável pela janela de menu do cliente que possue
     * as funcionalidades de adotar pets, ver os pets já adotados,
     * ver informações do usuário e deletar conta.
     * 
     * @param adocao
     * @param nomeCliente
     */
    private static void menuCliente(Adocao adocao, String nomeCliente) {
        Scanner scan3 = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("* Menu do cliente *");
            System.out.println();
            System.out.println("1) Acessar pets adotados");
            System.out.println("2) Adotar pet");
            System.out.println("3) Ver informações de usuário");
            System.out.println("4) Apagar conta");
            System.out.println("5) Voltar ao menu de adoção");

            String opcao = scan3.next();

            if (opcao.equals("1")) {
                adocao.petsDoCliente(nomeCliente);
            } else if (opcao.equals("2")) {
                adocao.adotarPet(nomeCliente);
            } else if (opcao.equals("3")) {
                adocao.dadosCliente(nomeCliente);
            } else if (opcao.equals("4")) {
                try {
                    System.out.print("Confirme seu id para deletar a conta: ");
                    int idInformado = scan3.nextInt();
                    adocao.removerCliente(nomeCliente, idInformado);
                    System.out.println("Conta deletada com sucesso!");
                    System.out.println();
                    break;
                } catch (Exception e) {
                    System.out.println("Não foi possível deletar sua conta!");
                }
                System.out.println();
            } else if (opcao.equals("5")) {
                break;
            } else {
                System.out.println();
                System.out.println("Comando inválido!");
                System.out.println();
            }
        }

    }
}
