package max.carol;

public class Suspensao {
    
    /*
     * 2. Suspensão
            Atributos:
            • tipo (String)
            • material (String)
            • altura (double)
            • rigidez (int)
            • marca (String)
            Métodos:
            • ajustarAltura(double novaAltura): Ajusta a altura da suspensão.
            • verificarEstado(): Retorna o estado atual da suspensão.
            • substituir(): Substitui a suspensão por uma nova.
     */

    private String tipo;
    private String material;
    private double altura;
    private int rigidez;
    private String marca;

    public Suspensao(String tipo, String material, double altura, int rigidez, String marca) {
        this.tipo = tipo;
        this.material = material;
        this.altura = altura;
        this.rigidez = rigidez;
        this.marca = marca;
    }

    public void ajustarAltura(double novaAltura) {
        this.altura = novaAltura;
    }

    public String verificarEstado() {
        return "Suspensão em bom estado.";
    }

    public void substituir() {
        System.out.println("Suspensão substituída por uma nova.");
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public double getAltura() {
        return altura;
    }

    public int getRigidez() {
        return rigidez;
    }

    public String getMarca() {
        return marca;
    }
}