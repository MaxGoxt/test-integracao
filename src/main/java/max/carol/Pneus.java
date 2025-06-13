package max.carol;

import java.util.List;

public class Pneus {
    private String tamanho;
    private String tipo;
    private double pressao;
    private String marca;
    private String estado;

    public enum posicaoPneu {
        DIANTEIRO_ESQUERDO,
        DIANTEIRO_DIREITO,
        TRASEIRO_ESQUERDO,
        TRASEIRO_DIREITO,
    }

    private posicaoPneu posicao;

    // Construtor principal
    public Pneus(
            String tamanho,
            String tipo,
            double pressao,
            String marca,
            String estado,
            posicaoPneu posicaoPneu) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.pressao = pressao;
        this.marca = marca;
        this.estado = estado;
        this.posicao = posicaoPneu;
    }

    public Pneus(posicaoPneu posicao) {
        this("16", "radial", 32.0, "Pirelli", "novo", posicao);
    }

    public void verificarPressao() {
        System.out.println("A pressão do pneu " + marca + " é: " + pressao + " psi.");
    }

    public String ajustarPressao(double novaPressao) {
        this.pressao = novaPressao;
        System.out.println("A pressão do pneu " + marca + " foi ajustada para: " + pressao + " psi.");
        return "Pressão ajustada com sucesso!";
    }

    public void ajustarPressaoParaCurva(int angulo) {
        if (posicao == posicaoPneu.DIANTEIRO_ESQUERDO) {
            pressao += 0.5;
        } else if (posicao == posicaoPneu.DIANTEIRO_DIREITO) {
            pressao -= 0.5;
        }
        // Traseiros mantêm a pressão
    }

    public double getPressaoAtual() {
        return pressao;
    }

    public void substituir() {
        System.out.println("O pneu " + marca + " foi substituído.");
    }

    public String[] getModelosDisponiveis() {
        return new String[] { "Pirelli", "Michelin", "Goodyear" };
    }

    public List<String> getAvisosDeUso() {
        return List.of("Verifique a pressão semanalmente", "Evite buracos", "Substitua a cada 50.000 km");
    }

    public String getManualUso() {
        return "1. Calibre os pneus\n2. Use o bico correto\n3. Verifique o desgaste";
    }

    public Pneus getEstepeReserva() {
        return null;
    }

    public void falhaPneu() {
        throw new IllegalStateException("Falha no pneu detectada!");
    }

    // Getters
    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPressao() {
        return pressao;
    }

    public String getMarca() {
        return marca;
    }

    public posicaoPneu getPosicao() {
        return posicao;
    }

    public String getEstado() {
        return estado;
    }
}
