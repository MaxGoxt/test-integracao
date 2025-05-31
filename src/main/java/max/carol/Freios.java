package max.carol;

import java.util.List;

public class Freios {

    private String tipo;
    private String material;
    private double tamanho;
    private String marca;
    private double nivelDeDesgaste;

    public Freios(String tipo, String material, double tamanho, String marca, double nivelDeDesgaste) {
        this.tipo = tipo;
        this.material = material;
        this.tamanho = tamanho;
        this.marca = marca;
        this.nivelDeDesgaste = nivelDeDesgaste;
    }

    public double verificarDesgaste() {
        return nivelDeDesgaste;
    }

    public void substituirPastilhas() {
        System.out.println("Pastilhas de freio substituídas.");
    }

    public void ajustarFreio() {
        System.out.println("Sistema de freio ajustado.");
    }

    // Métodos auxiliares para testes

    public String[] getTiposDisponiveis() {
        return new String[]{"disco", "tambor", "hidráulico"};
    }

    public List<String> getMarcasRecomendadas() {
        return List.of("Brembo", "Bosch", "TRW");
    }

    public String getManualFreio() {
        return "1. Verifique o desgaste\n2. Substitua as pastilhas\n3. Ajuste o sistema";
    }

    public Freios getFreioReserva() {
        return null; // simula ausência de freio reserva
    }

    public void ajustarComErro() {
        throw new IllegalStateException("Erro ao ajustar o freio!");
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

    public String getMaterial() {
        return material;
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public double getNivelDeDesgaste() {
        return nivelDeDesgaste;
    }
}
