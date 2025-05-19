package max.carol;

public class Suspensao {
    
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

    // Métodos auxiliares para os testes

    public String[] getNomesGetters() {
        return new String[] { "getTipo", "getMaterial", "getMarca" };
    }
    
    public Object[] getValoresAtributos() {
        return new Object[] { tipo, material, marca };
    }

    public Object metodoQueRetornaNull() {
        return null;
    }

    public void metodoQueLancaExcecao() {
        throw new IllegalArgumentException("Erro simulado");
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
