package max.carol;

/*
 * 10. Pneus
Atributos:
• tamanho (String)
• tipo (String)
• pressão (double)
• marca (String)
• estado (String)
Métodos:
• verificarPressão(): Verifica a pressão dos pneus.
• ajustarPressão(double novaPressão): Ajusta a pressão dos pneus.
• substituir(): Substitui o pneu.
 */

public class Pneus {
    private String tamanho;
    private String tipo;
    private double pressao;
    private String marca;
    private String estado;

    public Pneus(String tamanho, String tipo, double pressao, String marca, String estado) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.pressao = pressao;
        this.marca = marca;
        this.estado = estado;
    }

    public void verificarPressao() {
        System.out.println("A pressão do pneu " + marca + " é: " + pressao + " psi.");
    }

    public void ajustarPressao(double novaPressao) {
        this.pressao = novaPressao;
        System.out.println("A pressão do pneu " + marca + " foi ajustada para: " + pressao + " psi.");
    }

    public void substituir() {
        System.out.println("O pneu " + marca + " foi substituído.");
    }

    // Getters

    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPressao() {
        return pressao;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }
}