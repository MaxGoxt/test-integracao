package max.carol;

import java.util.List;

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

    // Métodos auxiliares para testes JUnit

    public String[] getSensoresConectados() {
        return new String[]{"temperatura", "pressão", "rotação"};
    }

    public List<String> getModelosDisponiveis() {
        return List.of("V8", "V6", "1.0 TSI");
    }

    public String getManualDeUso() {
        return "1. Ligue o motor\n2. Aqueça por 1 minuto\n3. Mantenha revisões em dia";
    }

    public Motor getMotorReserva() {
        return null;
    }

    public void falhaGrave() {
        throw new IllegalStateException("Falha grave no motor!");
    }

    public void operacaoLenta() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}
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
