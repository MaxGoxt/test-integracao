package max.carol;

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

    public boolean isEstadoOk() {
        return estado;
    }

    public String getMarca() {
        return marca;
    }

    // Métodos auxiliares para os testes:

    // Retorna os nomes dos getters da classe
    public String[] getNomesGetters() {
        return new String[] { "getVoltagem", "getCapacidade", "getTipoDeBateria", "isEstado", "getMarca" };
    }

    // Retorna os valores atuais dos atributos, na mesma ordem do getNomesGetters
    public Object[] getValoresAtributos() {
        return new Object[] { voltagem, capacidade, tipoDeBateria, estado, marca };
    }

    // Método que lança uma exceção para teste de assertThrows
    public void metodoQueLancaExcecao() {
        throw new IllegalStateException("Erro intencional");
    }

    // Método que retorna null para teste de assertNull
    public Object metodoQueRetornaNull() {
        return null;
    }
}
