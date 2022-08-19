/**
 * Classe molde para os tipos de animais que serão adotados
 * 
 * @author Bruno Melo
 */
package SistemaDeAdocao.Animais;

import java.text.DecimalFormat;

public abstract class Animal{

    private int age;
    private float peso;
    protected String tipoDeAlimento, especie;
    protected int id;
    /**
     * Método construtor da classe
     * @param age
     * @param peso
     * @param id
     */
    public Animal(int age, float peso, int id) {
        this.age = age;
        this.peso = peso;
        this.id = id;
    }

    /**
     * O método abstrato abaixo determinará o tipo de alimento que cada animal
     * comerá
     */
    protected abstract String tipoAlimento();

    /**
     * O método abstrato abaixo determinará o som que cada animal fará
     */
    public abstract String som();

    public void setAge(int age) {
        this.age = age;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setTipoDeAlimento(String tipoDeAlimento) {
        this.tipoDeAlimento = tipoDeAlimento;
    }

    public int getAge() {
        return age;
    }

    public float getPeso() {
        return peso;
    }

    public String getTipoDeAlimento() {
        return tipoDeAlimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.00");
        String pesoFormatado = formatter.format(this.peso);
        return "" + this.id + ") " + this.especie + " => Idade:" + this.age + " => Peso:" + pesoFormatado + " => Alimentação:" + this.tipoDeAlimento;
    }

}
