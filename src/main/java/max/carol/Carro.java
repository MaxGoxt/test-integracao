package max.carol;

import java.util.List;

public class Carro {
    /*
     * 1. Carro
     * Atributos:
     * • modelo (String)
     * • ano (int)
     * • cor (String)
     * • placa (String)
     * • quilometragem (double)
     * Métodos:
     * • ligar(): Liga o carro.
     * • desligar(): Desliga o carro.
     * • atualizarQuilometragem(double km): Atualiza a quilometragem do carro.
     */

    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private double quilometragem;
    private boolean ligado;
    private Bancos bancos;
    private Freios freios;
    private Luzes luzes;
    private Motor motor;
    private Painel painel;
    private Pneus pneus;
    private SistemaDeCombustivel sistemaDeCombustivel;
    private SistemaDeDirecao sistemaDeDirecao;
    private SistemaEletrico sistemaEletrico;
    private Suspensao suspensao;
    private Transmissao transmissao;

    public static void main(String[] args) {
        System.out.println("Carro.java");
    }

    public Carro(String modelo, int ano, String cor, String placa, double quilometragem) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.ligado = false; // Inicialmente o carro está desligado
    }

    public void ligar() {

        if (sistemaEletrico == null) {
            throw new IllegalStateException("Sistema elétrico não está disponível.");
        }
        if (sistemaEletrico.isEstadoOk()) {
            throw new IllegalStateException("Bateria está descarregada.");
        }

        if (sistemaDeCombustivel == null) {
            throw new IllegalStateException("Sistema de combustível não está disponível.");            
        }

        if (sistemaDeCombustivel.getNivelDeCombustivel() <= 0) {
            throw new IllegalStateException("Tanque de combustível está vazio.");
        }

        if (motor == null) {
            throw new IllegalStateException("Motor não está disponível.");
        }

        if (transmissao == null) {
            throw new IllegalStateException("Transmissão não está disponível.");
        }
        
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("Carro já está ligado.");
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Carro já está desligado.");
        }
    }

    public void atualizarQuilometragem(double km) {
        if (km > 0) {
            this.quilometragem += km;
            System.out.println("Quilometragem atualizada para: " + this.quilometragem);
        } else {
            System.out.println("Valor de quilometragem inválido.");
        }
    }

    // Getters

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public boolean isLigado() {
        return ligado;
    }

    // toString

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", quilometragem=" + quilometragem +
                ", ligado=" + ligado +
                '}';
    }

    public String[] getServicosPendentes() {
        return new String[] { "troca de óleo", "revisão dos freios" };
    }

    public List<String> getManutencoesRecentes() {
        return List.of("troca de óleo", "alinhamento");
    }

    public String getManualUsuario() {
        return "1. Ligue o carro\n2. Dirija com segurança";
    }

    public Carro getProximoCarro() {
        return null; // simula ausência de próximo carro
    }

    public void acelerarNegativo() {
        throw new IllegalArgumentException("Velocidade não pode ser negativa!");
    }

    public void operacaoDemorada() {
        try {
            Thread.sleep(2000); // simula operação lenta
        } catch (InterruptedException ignored) {
        }
    }

}
