package max.carol;

import java.util.List;

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

    // Métodos auxiliares para testes com JUnit

    public String[] getCoresDisponiveis() {
        return new String[]{"branca", "amarela", "azul"};
    }

    public List<String> getModelosDisponiveis() {
        return List.of("LED", "Xênon", "Halógena");
    }

    public String getManualLuzes() {
        return "1. Ligue as luzes\n2. Ajuste a intensidade\n3. Verifique a cor";
    }

    public Luzes getLuzReserva() {
        return null; // simula ausência
    }

    public void ajustarErro() {
        throw new IllegalArgumentException("Intensidade inválida!");
    }

    public void operacaoDemorada() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
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
