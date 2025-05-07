package max.carol;

/*
 * 6. Sistema de Combustível
        Atributos:
        • tipoDeCombustível (String)
        • capacidade (double)
        • nívelDeCombustível (double)
        • marca (String)
        • estado (boolean)
        Métodos:
        • verificarNível(): Verifica o nível de combustível.
        • abastecer(double quantidade): Abastece o tanque com uma quantidade
        específica de combustível.
        • substituirTanque(): Substitui o tanque de combustível.
 */

public class SistemaDeCombustivel {

    private String tipoDeCombustivel;
    private double capacidade;
    private double nivelDeCombustivel;
    private String marca;
    private boolean estado;

    public SistemaDeCombustivel(String tipoDeCombustivel, double capacidade, double nivelDeCombustivel, String marca, boolean estado) {
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.capacidade = capacidade;
        this.nivelDeCombustivel = nivelDeCombustivel;
        this.marca = marca;
        this.estado = estado;
    }

    public double verificarNivel() {
        return nivelDeCombustivel;
    }

    public void abastecer(double quantidade) {
        if (nivelDeCombustivel + quantidade <= capacidade) {
            nivelDeCombustivel += quantidade;
            System.out.println("Abastecido com " + quantidade + " litros. Nível atual: " + nivelDeCombustivel + " litros.");
        } else {
            System.out.println("Quantidade excede a capacidade do tanque.");
        }
    }

    public void substituirTanque() {
        System.out.println("Tanque de combustível substituído.");
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

    // toString
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