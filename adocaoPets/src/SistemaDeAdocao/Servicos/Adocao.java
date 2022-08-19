/**
 * Classe responsável pelo gerenciamento da adoção
 * @author Bruno Melo
 */
package SistemaDeAdocao.Servicos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import SistemaDeAdocao.Animais.*;

public class Adocao {
    private ArrayList<Animal> petsDisponiveis = new ArrayList<>();

    /**
     * Construtor que preenche a lista de pets disponíveis para adoção
     * sempre que o programa for aberto, e que cria dois arquivos .txt
     * referentes aos id's de usuários e pets.
     */
    public Adocao() {
        Dados.write("nextId.txt", "");
        Dados.write("nextIdPet.txt", "");


        for (int cont = 0; cont < 4; cont++) {
            Random r = new Random();
            Dados.writeNextIdPet("nextIdPet.txt");
            petsDisponiveis.add(new Gato(r.nextInt(1, 6), r.nextFloat(1f, 10f), Dados.readIdPet("nextIdPet.txt")));
        }

        for (int cont = 0; cont < 3; cont++) {
            Random r = new Random();
            Dados.writeNextIdPet("nextIdPet.txt");
            petsDisponiveis.add(new Cachorro(r.nextInt(1, 10), r.nextFloat(1f, 15f), Dados.readIdPet("nextIdPet.txt")));
        }

        for (Animal pet : petsDisponiveis) {
            Dados.write("pets.txt", pet.toString());
        }
    }

    /**
     * Método para adicionar um cliente no arquivo "clientes.txt" que
     * contém os clientes, sempre que um novo cliente for cadastrado.
     * 
     * @param cliente
     */
    public void addCliente(Cliente cliente) {// terminado
        try {
            if (encontrarCliente(cliente.getNome(), cliente.getId()) == false) {
                Dados.writeNextId("nextId.txt");
                String nomeArquivo = cliente.getNome() + ".txt";
                Dados.write(nomeArquivo, "Pets:");
                Dados.write("clientes.txt", cliente.toString());
                System.out.println("Cliente cadastrado com sucesso!");
                System.out.println();
            } else
                System.out.println(" Nome de usuário já existe");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Não foi possível cadastrar o cliente");
            System.out.println();
        }
    }

    /**
     * Método que remove um cliente do arquivo "clientes.txt"
     * ao usuário deletar a conta
     * 
     * @param id
     */
    public void removerCliente(String nome, int id) {
        try {
            String remocao = "Id:" + id;
            Dados.delete("clientes.txt", remocao);
            Dados.deleteAll(nome+".txt");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Cliente não encontrado");
            System.out.println();
        }
    }

    /**
     * Método que verifica as credenciais de um usuário quando
     * o mesmo tentar fazer login, retornando true se as credenciais
     * estiverem corretas e false caso contrário.
     * 
     * @param nome
     * @param id
     * @return
     */
    public boolean encontrarCliente(String nome, int id) {
        try {
            String dados = Dados.read("clientes.txt");
            if (dados.contains(nome + " => Id:" + id))
                return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Método que mostra todos os pets já
     * adotados pelo usuário.
     * 
     * @param nomeCliente
     */
    public void petsDoCliente(String nomeCliente) {
        try {
            System.out.println();
            String path = nomeCliente + ".txt";
            System.out.println(Dados.read(path));
            System.out.println();
        } catch (Exception e) {
            System.out.println("Não foi possível acessar seus pets!");
            System.out.println();
        }
    }

    /**
     * Método que faz a adoção de um pet para o usuário.
     * 
     * @param nomeCliente
     */
    public void adotarPet(String nomeCliente) {
        try {
            Scanner scanner = new Scanner(System.in);
            petsDisponiveis();
            System.out.print("Informe qual deseja adotar de acordo com a numeração: ");
            String numeroEscolhido = scanner.next();
            if (Dados.read("pets.txt").contains(numeroEscolhido + ")")) {
                System.out.print("Informe um nome para o seu pet: ");
                String nome = scanner.next();
                String[] textoSeparado = Dados.readLine2("pets.txt", numeroEscolhido + ")").split("\\)");
                Dados.write(nomeCliente + ".txt", nome + ":" + textoSeparado[1]);
                Dados.delete("pets.txt", numeroEscolhido + ")");
                System.out.println("Pet adotado com sucesso!");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void petsDisponiveis() {
        System.out.println();
        System.out.println("Pets disponíveis para adoção: ");
        System.out.println(Dados.read("pets.txt"));
        System.out.println();
    }

    public void dadosCliente(String nomeCliente) {
        try {
            System.out.println();
            System.out.println(Dados.readLine2("clientes.txt", nomeCliente));
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
