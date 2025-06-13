package max.carol;

import java.util.List;

public class Motor {

    private String tipo;
    private int potencia;
    private double cilindrada;
    private String marca;
    private boolean ligado;

    public Motor(
            String tipo,
            int potencia,
            double cilindrada,
            String marca,
            boolean ligado) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.marca = marca;
        this.ligado = ligado;
    }

    public String ligar() {
        ligado = true;
        return "Motor ligado.";
    }

    public String desligar() {
        ligado = false;
        return "Motor desligado.";
    }

    public String verificarLigado() {
        return ligado ? "Motor em bom ligado." : "Motor desligado.";
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

    public boolean isLigado() {
        return ligado;
    }
}
