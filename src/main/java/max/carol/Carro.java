package max.carol;

public class Carro {
    /*
     * 1. Carro
        Atributos:
        • modelo (String)
        • ano (int)
        • cor (String)
        • placa (String)
        • quilometragem (double)
        Métodos:
        • ligar(): Liga o carro.
        • desligar(): Desliga o carro.
        • atualizarQuilometragem(double km): Atualiza a quilometragem do carro.
     */
    
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private double quilometragem;
    private boolean ligado;

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

}
