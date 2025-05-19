package max.carol;

import java.util.List;

public class Bancos {
    private int quantidade;
    private String material;
    private String cor;
    private String tipo;
    private String estado;

    public Bancos(int quantidade, String material, String cor, String tipo, String estado) {
        this.quantidade = quantidade;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void ajustarEncosto(String posicao) {
        System.out.println("Ajustando o encosto do banco para a posição: " + posicao);
    }

    public void ajustarAltura(double novaAltura) {
        System.out.println("Ajustando a altura do banco para: " + novaAltura + " cm");
    }

    public void verificarEstado() {
        System.out.println("O estado do banco é: " + estado);
    }

    // Novos métodos para os testes
    public String[] getMateriaisDisponiveis() {
        return new String[]{"couro", "tecido", "sintético"};
    }

    public List<String> getCoresDisponiveis() {
        return List.of("preto", "cinza", "bege");
    }

    public String getManual() {
        return "1. Ajuste o encosto\n2. Ajuste a altura\n3. Verifique o estado";
    }

    public Bancos getBancoSubstituto() {
        return null; // simula ausência de substituto
    }

    public void ajustarAlturaInvalida() {
        throw new IllegalArgumentException("Altura inválida!");
    }

    public void operacaoLenta() {
        try {
            Thread.sleep(1500); // simula operação lenta
        } catch (InterruptedException ignored) {}
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
 