package max.carol;

/*
 * 5. Sistema de Direção
        Atributos:
        • tipo (String)
        • assistido (boolean)
        • material (String)
        • relação (double)
        • marca (String)
        Métodos:
        • ajustarDireção(double ângulo): Ajusta o ângulo de direção.
        • verificarEstado(): Verifica o estado do sistema de direção.
        • substituirComponente(String componente): Substitui um componente do
        sistema.
 */

public class SistemaDeDirecao {

    private String tipo;
    private boolean assistido;
    private String material;
    private double relacao;
    private String marca;

    public SistemaDeDirecao(String tipo, boolean assistido, String material, double relacao, String marca) {
        this.tipo = tipo;
        this.assistido = assistido;
        this.material = material;
        this.relacao = relacao;
        this.marca = marca;
    }

    public void ajustarDirecao(double angulo) {
        System.out.println("Direção ajustada para o ângulo: " + angulo + " graus.");
    }

    public String verificarEstado() {
        return "Sistema de direção em bom estado.";
    }

    public void substituirComponente(String componente) {
        System.out.println("Componente " + componente + " substituído.");
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public String getMaterial() {
        return material;
    }

    public double getRelacao() {
        return relacao;
    }

    public String getMarca() {
        return marca;
    }
}