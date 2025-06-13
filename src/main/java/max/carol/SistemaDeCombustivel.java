package max.carol;

import java.util.List;

public class SistemaDeCombustivel {

    private String tipoDeCombustivel;
    private double capacidade;
    private double nivelDeCombustivel;
    private String marca;
    private boolean estado;

    // Construtor completo
    public SistemaDeCombustivel(
            String tipoDeCombustivel,
            double capacidade,
            double nivelDeCombustivel,
            String marca,
            boolean estado) {
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.capacidade = capacidade;
        this.nivelDeCombustivel = nivelDeCombustivel;
        this.marca = marca;
        this.estado = estado;
    }

    public double verificarNivel() {
        return nivelDeCombustivel;
    }

    public void consumir(double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de consumo deve ser maior que zero.");
        }
        if (nivelDeCombustivel - quantidade >= 0) {
            nivelDeCombustivel -= quantidade;
        } else {
            throw new IllegalStateException("Combustível insuficiente para consumo.");
        }
    }

    public void abastecer(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para abastecimento.");
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        if (nivelDeCombustivel + quantidade <= capacidade) {
            nivelDeCombustivel += quantidade;
            System.out.println(
                    "Abastecido com " + quantidade + " litros. Nível atual: " + nivelDeCombustivel + " litros.");
        } else {
            System.out.println("Quantidade excede a capacidade do tanque.");
        }
    }

    public void substituirTanque() {
        System.out.println("Tanque de combustível substituído.");
    }

    // Métodos auxiliares para testes JUnit

    public String[] getTiposDeCombustivelDisponiveis() {
        return new String[] { "Gasolina", "Etanol", "Diesel", "GNV" };
    }

    public List<String> getRegrasDeSeguranca() {
        return List.of(
                "Não fume durante o abastecimento",
                "Desligue o motor ao abastecer",
                "Evite transbordamento");
    }

    public String getInstrucoesDeUso() {
        return "1. Abra a tampa do tanque\n2. Insira a bomba\n3. Selecione o tipo de combustível\n4. Abasteça";
    }

    public SistemaDeCombustivel getTanqueReserva() {
        return null; // útil para teste com assertNull
    }

    public void causarFalhaNoTanque() {
        throw new RuntimeException("Falha no sistema de combustível detectada!");
    }

    public void abastecimentoDemorado() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException ignored) {
        }
    }

    // Getters

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public double getNivelDeCombustivel() {
        return nivelDeCombustivel;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "SistemaDeCombustivel{" +
                "tipoDeCombustivel='" + tipoDeCombustivel + '\'' +
                ", capacidade=" + capacidade +
                ", nivelDeCombustivel=" + nivelDeCombustivel +
                ", marca='" + marca + '\'' +
                ", estado=" + estado +
                '}';
    }
}
