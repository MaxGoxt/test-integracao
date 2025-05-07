package max.carol;

/*
 * 7. Motor
        Atributos:
        • tipo (String)
        • potência (int)
        • cilindrada (double)
        • marca (String)
        • estado (boolean)
        Métodos:
        • ligar(): Liga o motor.
        • desligar(): Desliga o motor.
        • verificarEstado(): Verifica o estado do motor.
 */

public class Motor {

    private String tipo;
    private int potencia;
    private double cilindrada;
    private String marca;
    private boolean estado;

    public Motor(String tipo, int potencia, double cilindrada, String marca, boolean estado) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.estado = estado;
    }

    public void ligar() {
        estado = true;
        System.out.println("Motor ligado.");
    }

    public void desligar() {
        estado = false;
        System.out.println("Motor desligado.");
    }

    public String verificarEstado() {
        return estado ? "Motor em bom estado." : "Motor desligado.";
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEstado() {
        return estado;
    }
}