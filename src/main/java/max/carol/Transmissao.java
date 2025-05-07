package max.carol;

public class Transmissao {
    /*
     * 8. Sistema de Transmissão
        Atributos:
        • tipo (String)
        • númeroDeMarchas (int)
        • material (String)
        • marca (String)
        • estado (boolean)
        Métodos:
        • trocarMarcha(int marcha): Troca a marcha da transmissão.
        • verificarEstado(): Verifica o estado do sistema de transmissão.
        • substituirComponente(String componente): Substitui um componente da
          transmissão
     */

    private String tipo;
    private int numeroDeMarchas;
    private String material;
    private String marca;
    private boolean estado; // true se o sistema de transmissão está funcionando, false caso contrário

    public Transmissao(String tipo, int numeroDeMarchas, String material, String marca) {
        this.tipo = tipo;
        this.numeroDeMarchas = numeroDeMarchas;
        this.material = material;
        this.marca = marca;
        this.estado = true; // Inicialmente o sistema de transmissão está funcionando
    }

    public void trocarMarcha(int marcha) {
        if (estado) {
            if (marcha >= 1 && marcha <= numeroDeMarchas) {
                System.out.println("Marcha trocada para: " + marcha);
            } else {
                System.out.println("Marcha inválida. O número de marchas disponíveis é: " + numeroDeMarchas);
            }
        } else {
            System.out.println("Sistema de transmissão fora de funcionamento. Não é possível trocar a marcha.");
        }
    }

    public void verificarEstado() {
        if (estado) {
            System.out.println("Sistema de transmissão funcionando corretamente.");
        } else {
            System.out.println("Sistema de transmissão fora de funcionamento.");
        }
    }

    public void substituirComponente(String componente) {
        if (!estado) {
            System.out.println("Substituindo componente: " + componente);
            estado = true; // Após a substituição, o sistema de transmissão volta a funcionar
            System.out.println("Sistema de transmissão funcionando novamente.");
        } else {
            System.out.println("Sistema de transmissão já está funcionando. Nenhuma substituição necessária.");
        }
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    public String getMaterial() {
        return material;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEstado() {
        return estado;
    }

    // toString()

    @Override
    public String toString() {
        return "Transmissao{" +
                "tipo='" + tipo + '\'' +
                ", numeroDeMarchas=" + numeroDeMarchas +
                ", material='" + material + '\'' +
                ", marca='" + marca + '\'' +
                ", estado=" + estado +
                '}';
    }
}
