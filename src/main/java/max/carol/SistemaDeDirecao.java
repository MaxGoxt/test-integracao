package max.carol;

import java.util.List;

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

    // Métodos auxiliares para testes JUnit

    public String[] ComponentesPrincipais() {
        return new String[]{"Volante", "Caixa de direção", "Coluna", "Bomba hidráulica"};
    }

    public List<String> getChecklistManutencao() {
        return List.of(
            "Verificar fluido de direção",
            "Inspecionar folgas no volante",
            "Checar bomba hidráulica"
        );
    }

    public String getInstrucoesDeManuseio() {
        return "1. Gire o volante suavemente\n2. Evite manobras bruscas\n3. Mantenha manutenção em dia";
    }

    public SistemaDeDirecao getDirecaoReserva() {
        return null; // útil para teste com assertNull
    }

    public void simularFalhaGrave() {
        throw new IllegalStateException("Falha crítica no sistema de direção!");
    }

    public void testeDemorado() {
        try {
            Thread.sleep(800); // menos de 1 segundo
        } catch (InterruptedException ignored) {}
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
