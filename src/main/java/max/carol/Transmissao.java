package max.carol;

public class Transmissao {
    private String tipo;
    private int numeroDeMarchas;
    private String material;
    private String marca;
    private boolean estado;

    public Transmissao(String tipo, int numeroDeMarchas, String material, String marca) {
        this(tipo, numeroDeMarchas, material, marca, true);
    }

    public Transmissao(String tipo, int numeroDeMarchas, String material, String marca, boolean estado) {
        this.tipo = tipo;
        this.numeroDeMarchas = numeroDeMarchas;
        this.material = material;
        this.marca = marca;
        this.estado = estado;
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
            estado = true;
            System.out.println("Sistema de transmissão funcionando novamente.");
        } else {
            System.out.println("Sistema de transmissão já está funcionando. Nenhuma substituição necessária.");
        }
    }

    // Método para simular falha
    public void falharSistema() {
        this.estado = false;
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
}
