package max.carol;

/*
 * 4. Luzes
    Atributos:
    • tipo (String)
    • intensidade (int)
    • cor (String)
    • estado (boolean)
    • modelo (String)
    Métodos:
    • ligar(): Liga as luzes.
    • desligar(): Desliga as luzes.
    • ajustarIntensidade(int novaIntensidade): Ajusta a intensidade das luzes.
 */

public class Luzes {

    private String tipo;
    private int intensidade;
    private String cor;
    private boolean estado;
    private String modelo;

    public Luzes(String tipo, int intensidade, String cor, boolean estado, String modelo) {
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.cor = cor;
        this.estado = estado;
        this.modelo = modelo;
    }

    public void ligar() {
        estado = true;
        System.out.println("Luzes ligadas.");
    }

    public void desligar() {
        estado = false;
        System.out.println("Luzes desligadas.");
    }

    public void ajustarIntensidade(int novaIntensidade) {
        this.intensidade = novaIntensidade;
        System.out.println("Intensidade ajustada para: " + novaIntensidade);
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public String getCor() {
        return cor;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getModelo() {
        return modelo;
    }
}