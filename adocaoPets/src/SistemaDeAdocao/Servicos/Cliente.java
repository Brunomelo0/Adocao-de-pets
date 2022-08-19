/**
 * Classe representa os dados de um cliente da adoção
 * @author Bruno Melo
 */
package SistemaDeAdocao.Servicos;

public class Cliente {

    private String nome;
    private int idade;
    private String endereco;
    private int id;

    /**
     * Método construtor da classe.
     * @param nome
     * @param idade
     * @param endereco
     * @param id
     */
    public Cliente(String nome, int idade, String endereco, int id) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.nome + " => Id:" + this.id + " => Idade:" + this.idade + " => Endereco:" + this.endereco; 
    }

}
