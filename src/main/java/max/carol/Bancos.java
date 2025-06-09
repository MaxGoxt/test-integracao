package max.carol;

import java.util.List;

public class Bancos {
    private int quantidade;
    private String estado;
    private String material;
    private String cor;
    private String tipo;
    private String posicaoEncosto;
    private double alturaBanco;


    // Construtor completo
    public Bancos(int quantidade, String estado, String material, String cor, String tipo) {
        this.quantidade = quantidade;
        this.estado = estado;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
    }

    public String ajustarEncosto(String posicao) {
        System.out.println("Ajustando o encosto do banco para a posição: " + posicao);
        if (posicao == null || posicao.isEmpty()) {
            throw new IllegalStateException("Posição inválida para o encosto");
        }
        this.posicaoEncosto = posicao;
        return "Encosto ajustado para " + posicaoEncosto;
    }

    public String ajustarAltura(double novaAltura) {
        System.out.println("Ajustando a altura do banco para: " + novaAltura + " cm");
        if (novaAltura < 0) {
            this.ajustarAlturaInvalida();
        }
        if (novaAltura > 100) {
            return "Altura máxima permitida é 100 cm";
        }
        this.alturaBanco = novaAltura;
        return "Altura ajustada para " + alturaBanco + " cm";
    }

    public String verificarEstado() {
        System.out.println("O estado do banco é: " + estado);
        return "Estado do banco: " + estado;
    }

    public String[] getMateriaisDisponiveis() {
        return new String[]{"couro", "tecido", "sintético"};
    }

    public List<String> getCoresDisponiveis() {
        return List.of("preto", "cinza", "bege");
    }

    public void ajustarAlturaInvalida() {
        throw new IllegalArgumentException("Altura inválida!");
    }

    // Getters
    public int getQuantidade() {
        return quantidade;
    }

    public String getEstado() {
        return estado;
    }
}
