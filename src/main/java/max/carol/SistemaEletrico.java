package max.carol;

public class SistemaEletrico {

    private double voltagem;
    private double capacidade;
    private String tipoDeBateria;
    private boolean estado;
    private String marca;
    private int nivelCarga;

    // ✅ Construtor completo (já existente)
    public SistemaEletrico(
            double voltagem,
            double capacidade,
            String tipoDeBateria,
            boolean estado,
            String marca) {
        this.voltagem = voltagem;
        this.capacidade = capacidade;
        this.tipoDeBateria = tipoDeBateria;
        this.estado = estado;
        this.marca = marca;
        this.nivelCarga = 100; // Inicializa o nível de carga como 100%
    }


    public void setNivelCarga(int nivel) {
        this.nivelCarga = nivel;
        this.estado = nivel >= 30; // considera fraca se < 30%
    }

    public int getNivelCarga() {
        return this.nivelCarga;
    }

    public SistemaEletrico(boolean estado) {
        this(12.0, 60.0, "Chumbo-ácido", estado, "Moura");
    }

    public String verificarBateria() {
        if (estado) {
            return "Bateria está em bom estado.";
        } else {
            return "Bateria precisa ser substituída.";
        }
    }

    public void substituirBateria(String tipoDeBateria, double capacidade, double voltagem) {
        this.tipoDeBateria = tipoDeBateria;
        this.capacidade = capacidade;
        this.voltagem = voltagem;
        System.out.println("Bateria substituída.");
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

    public String[] getNomesGetters() {
        return new String[] { "getVoltagem", "getCapacidade", "getTipoDeBateria", "isEstado", "getMarca" };
    }

    public Object[] getValoresAtributos() {
        return new Object[] { voltagem, capacidade, tipoDeBateria, estado, marca };
    }

    public void metodoQueLancaExcecao() {
        throw new IllegalStateException("Erro intencional");
    }

    public Object metodoQueRetornaNull() {
        return null;
    }
}
