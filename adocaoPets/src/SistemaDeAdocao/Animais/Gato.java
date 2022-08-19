/**
 * Classe herdeira da classe Animal que representa os gatos para adoção
 * 
 * @author Bruno Melo
 */
package SistemaDeAdocao.Animais;

public class Gato extends Animal {

    /**
     * Método construtor da classe
     * @param age
     * @param peso
     * @param id
     */
    public Gato(int age, float peso, int id) {
        super(age, peso, id);
        setTipoDeAlimento(tipoAlimento());
        especie = "Gato";
    }

    @Override
    protected String tipoAlimento() {
        return "Ração";
    }

    @Override
    public String som() {
        return "Miau!";
    }
}
