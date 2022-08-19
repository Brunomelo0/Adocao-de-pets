/**
 * Classe herdeira da classe Animal que representa os cachorros para adoção
 * 
 * @author Bruno Melo
 */
package SistemaDeAdocao.Animais;

public class Cachorro extends Animal{
    public Cachorro(int age, float peso, int id) {
        super(age, peso, id);
        setTipoDeAlimento(tipoAlimento());
        especie = "Cachorro";
    }

    @Override
    protected String tipoAlimento() {
        return "Ração";
    }

    @Override
    public String som() {
        return "Auau!";
    }

}
