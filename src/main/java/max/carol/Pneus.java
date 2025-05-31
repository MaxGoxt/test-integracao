package max.carol;

import java.util.List;


public class Pneus {
    private String tamanho;
    private String tipo;
    private double pressao;
    private String marca;
    private String estado;
    enum posicaoPneu {
        DIANTEIRO_ESQUERDO,
        DIANTEIRO_DIREITO,
        TRASEIRO_ESQUERDO,
        TRASEIRO_DIREITO,
    }
    private posicaoPneu posicao;
    
    public Pneus(String tamanho, String tipo, double pressao, String marca, String estado, posicaoPneu posicaoPneu) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.pressao = pressao;
        this.marca = marca;
        this.estado = estado;
        this.posicao = posicaoPneu;
    }

    public void verificarPressao() {
        System.out.println("A pressão do pneu " + marca + " é: " + pressao + " psi.");
    }

    public void ajustarPressao(double novaPressao) {
        this.pressao = novaPressao;
        System.out.println("A pressão do pneu " + marca + " foi ajustada para: " + pressao + " psi.");
    }

    public void substituir() {
        System.out.println("O pneu " + marca + " foi substituído.");
    }

    // Métodos auxiliares para testes

    public String[] getModelosDisponiveis() {
        return new String[] {"Pirelli", "Michelin", "Goodyear"};
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

    public void calibragemDemorada() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
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
