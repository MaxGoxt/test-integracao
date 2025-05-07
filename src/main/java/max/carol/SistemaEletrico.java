package max.carol;

/*
 * 9. Sistema Elétrico
        Atributos:
        • voltagem (double)
        • capacidade (double)
        • tipoDeBateria (String)
        • estado (boolean)
        • marca (String)
        Métodos:
        • verificarBateria(): Verifica o estado da bateria.
        • substituirBateria(): Substitui a bateria.
        • testarSistema(): Testa o sistema elétrico.
 */

public class SistemaEletrico {

    private double voltagem;
    private double capacidade;
    private String tipoDeBateria;
    private boolean estado;
    private String marca;

    public SistemaEletrico(double voltagem, double capacidade, String tipoDeBateria, boolean estado, String marca) {
        this.voltagem = voltagem;
        this.capacidade = capacidade;
        this.tipoDeBateria = tipoDeBateria;
        this.estado = estado;
        this.marca = marca;
    }

    public String verificarBateria() {
        return estado ? "Bateria em bom estado." : "Bateria descarregada.";
    }

    public void substituirBateria() {
        System.out.println("Bateria substituída.");
    }

    public void testarSistema() {
        System.out.println("Sistema elétrico testado com sucesso.");
    }

    // Getters

    public double getVoltagem() {
        return voltagem;
    }

    public double getCapacidade() {
        return capacidade;
    }
    
    public String getTipoDeBateria() {
        return tipoDeBateria;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getMarca() {
        return marca;
    }
}