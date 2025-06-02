package max.carol;

import java.util.List;

import max.carol.Transmissao.MarchaManual;
import max.carol.Transmissao.Tipos;

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
    private Integer velocidade = 0; // Velocidade inicial do carro
    private Integer velocidadeMaxima;
    private Bancos bancos;
    private Freios freios;
    private Luzes luzes;
    private Motor motor;
    private Painel painel;
    private List<Pneus> pneus; // Array de pneus
    private SistemaDeCombustivel sistemaDeCombustivel;
    private SistemaDeDirecao sistemaDeDirecao;
    private SistemaEletrico sistemaEletrico;
    private Suspensao suspensao;
    private Transmissao transmissao;

    public static void main(String[] args) {
        System.out.println("Carro.java");
    }

    public Carro(
            String modelo,
            int ano,
            String cor,
            String placa,
            double quilometragem,
            Transmissao transmissao,
            Pneus pneuDianteEsquerdo,
            Pneus pneuDianteiroDireito,
            Pneus pneuTraseiroEsquerdo,
            Pneus pneuTraseiroDireito

    ) {

        if (modelo == null || modelo.isEmpty()) {
            throw new NullPointerException("Modelo não pode ser nulo ou vazio.");
        }
        if (ano <= 1885) { // O primeiro carro foi inventado em 1886
            throw new NullPointerException("Ano inválido para o carro.");
        }
        if (cor == null || cor.isEmpty()) {
            throw new NullPointerException("Cor não pode ser nula ou vazia.");
        }
        if (placa == null || placa.isEmpty()) {
            throw new NullPointerException("Placa não pode ser nula ou vazia.");
        }
        if (quilometragem < 0) {
            throw new IllegalArgumentException("Quilometragem não pode ser negativa.");
        }
        if (pneuDianteEsquerdo == null || pneuDianteiroDireito == null || pneuTraseiroEsquerdo == null
                || pneuTraseiroDireito == null) {
            throw new NullPointerException("Todos os pneus devem ser fornecidos.");
        }
        if (pneuDianteEsquerdo.getPosicao() != Pneus.posicaoPneu.DIANTEIRO_ESQUERDO ||
                pneuDianteiroDireito.getPosicao() != Pneus.posicaoPneu.DIANTEIRO_DIREITO ||
                pneuTraseiroEsquerdo.getPosicao() != Pneus.posicaoPneu.TRASEIRO_ESQUERDO ||
                pneuTraseiroDireito.getPosicao() != Pneus.posicaoPneu.TRASEIRO_DIREITO) {
            throw new IllegalArgumentException("Pneus devem estar nas posições corretas.");
        }

        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.ligado = false; // Inicialmente o carro está
        this.pneus = List.of(pneuDianteEsquerdo, pneuDianteiroDireito, pneuTraseiroEsquerdo, pneuTraseiroDireito);
    }

    public void ligar() {

        if (sistemaEletrico == null) {
            throw new NullPointerException("Sistema elétrico não está disponível.");
        }
        if (!sistemaEletrico.isEstadoOk()) {
            throw new IllegalStateException("Bateria está descarregada.");
        }

        if (sistemaDeCombustivel == null) {
            throw new NullPointerException("Sistema de combustível não está disponível.");
        }

        if (sistemaDeCombustivel.getNivelDeCombustivel() <= 0) {
            throw new IllegalStateException("Tanque de combustível está vazio.");
        }

        if (motor == null) {
            throw new NullPointerException("Motor não está disponível.");
        }

        if (transmissao == null) {
            throw new NullPointerException("Transmissão não está disponível.");
        }

        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("Carro já está ligado.");
        }
    }

    public String desligar() {
        if (ligado) {
            ligado = false;
            velocidade = 0; // Reseta a velocidade ao desligar
            return "Carro desligado.";
        } else {
            return "Carro já está desligado.";
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

    public String acelerar() {

        if (!ligado) {
            return "Carro desligado. Ligue o carro antes de acelerar.";
        }

        if (velocidade >= velocidadeMaxima) {
            return "Velocidade máxima atingida. Não é possível acelerar mais.";
        }

        if (transmissao == null) {
            return "Transmissão não está disponível. Não é possível acelerar.";
        }

        if (transmissao.getTipo() == Tipos.MarchaAutomatica) {
            velocidade += 10; // Aumenta a velocidade em 10 km/h
            return "Carro acelerando...";
        }

        if (transmissao.getTipo() == Tipos.MarchaManual && transmissao.getMarcha() == MarchaManual.N) {
            return "Carro em ponto morto. Mude a marcha para acelerar.";
        }

        velocidade += 10; // Aumenta a velocidade em 10 km/h
        return "Carro acelerando...";
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
