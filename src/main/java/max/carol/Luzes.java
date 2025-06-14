package max.carol;

public class Luzes {

    private String tipo;
    private int intensidade;
    private String cor;
    private boolean estado;
    private String modelo;
    private String luzDeFreioLigada;
    private boolean faroisAcesos;

    public Luzes(
            String tipo,
            int intensidade,
            String cor,
            boolean estado,
            String modelo,
            String luzDeFreioLigada) {
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.cor = cor;
        this.estado = estado;
        this.modelo = modelo;
        this.luzDeFreioLigada = luzDeFreioLigada;
        this.faroisAcesos = false; 
    }

    public String ligar() {
        estado = true;
        faroisAcesos = true;
        return "Luzes ligadas.";
    }

    public String desligar() {
        estado = false;
        faroisAcesos = false;
        return "Luzes desligadas.";
    }

    public String ajustarIntensidade(int novaIntensidade) {
        this.intensidade = novaIntensidade;
        return "Intensidade ajustada para: " + novaIntensidade;
    }

    public String LuzDeFreio() {
        return luzDeFreioLigada;
    }

    public boolean areFaroisAcesos() {
        return this.faroisAcesos;
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public String getCor() {
        return cor;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getModelo() {
        return modelo;
    }
}
