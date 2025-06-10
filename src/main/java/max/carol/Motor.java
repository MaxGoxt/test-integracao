package max.carol;

import java.util.List;

public class Motor {

    private String tipo;
    private int potencia;
    private double cilindrada;
    private String marca;
    private boolean estado;

    public Motor(
            String tipo,
            int potencia,
            double cilindrada,
            String marca,
            boolean estado) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.estado = estado;
    }

    public String ligar() {
        estado = true;
        return "Motor ligado.";
    }

    public String desligar() {
        estado = false;
        return "Motor desligado.";
    }

    public String verificarEstado() {
        return estado ? "Motor em bom estado." : "Motor desligado.";
    }

    // Métodos auxiliares para testes JUnit

    public String[] getSensoresConectados() {
        return new String[] { "temperatura", "pressão", "rotação" };
    }

    public List<String> getModelosDisponiveis() {
        return List.of("V8", "V6", "1.0 TSI");
    }

    public void falhaGrave() {
        throw new IllegalStateException("Falha grave no motor!");
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
