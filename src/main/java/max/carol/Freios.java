package max.carol;

/*
 * 3. Freios
        Atributos:
        • tipo (String)
        • material (String)
        • tamanho (double)
        • marca (String)
        • nivelDeDesgaste (double)
        Métodos:
        • verificarDesgaste(): Retorna o nível de desgaste dos freios.
        • substituirPastilhas(): Substitui as pastilhas de freio.
        • ajustarFreio(): Ajusta o sistema de freio.
 */

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