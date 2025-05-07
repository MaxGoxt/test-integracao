package max.carol;

/*
 * 13. Bancos
        Atributos:
        • quantidade (int)
        • material (String)
        • cor (String)
        • tipo (String)
        • estado (String)
        Métodos:
        • ajustarEncosto(String posição): Ajusta o encosto do banco.
        • ajustarAltura(double novaAltura): Ajusta a altura do banco.
        • verificarEstado(): Verifica o estado dos bancos.
 */

public class Bancos {
    private int quantidade;
    private String material;
    private String cor;
    private String tipo;
    private String estado;

    public Bancos(int quantidade, String material, String cor, String tipo, String estado) {
        this.quantidade = quantidade;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void ajustarEncosto(String posicao) {
        System.out.println("Ajustando o encosto do banco para a posição: " + posicao);
    }

    public void ajustarAltura(double novaAltura) {
        System.out.println("Ajustando a altura do banco para: " + novaAltura + " cm");
    }

    public void verificarEstado() {
        System.out.println("O estado do banco é: " + estado);
    }

    // Getters

    public int getQuantidade() {
        return quantidade;
    }

    public String getMaterial() {
        return material;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
}