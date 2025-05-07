package max.carol;

/*
 *  12. Portas
        Atributos:
        • quantidade (int)
        • material (String)
        • cor (String)
        • tipo (String)
        • estado (String)
        Métodos:
        • abrir(): Abre a porta.
        • fechar(): Fecha a porta.
        • verificarEstado(): Verifica o estado das portas.
 */

public class Portas {
    private int quantidade;
    private String material;
    private String cor;
    private String tipo;
    private String estado;

    public Portas(int quantidade, String material, String cor, String tipo, String estado) {
        this.quantidade = quantidade;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void abrir() {
        if (estado.equals("fechada")) {
            estado = "aberta";
            System.out.println("A porta foi aberta.");
        } else {
            System.out.println("A porta já está aberta.");
        }
    }

    public void fechar() {
        if (estado.equals("aberta")) {
            estado = "fechada";
            System.out.println("A porta foi fechada.");
        } else {
            System.out.println("A porta já está fechada.");
        }
    }

    public String verificarEstado() {
        return "A porta está " + estado + ".";
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