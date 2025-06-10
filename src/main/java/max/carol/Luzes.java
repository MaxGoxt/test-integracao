package max.carol;

public class Luzes {

    private String tipo;
    private int intensidade;
    private String cor;
    private boolean estado;
    private String modelo;
    private String luzDeFreioLigada;

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
    }

    public String ligar() {
        estado = true;
        return "Luzes ligadas.";
    }

    public String desligar() {
        estado = false;
        return "Luzes desligadas.";
    }

    public String ajustarIntensidade(int novaIntensidade) {
        this.intensidade = novaIntensidade;
        return "Intensidade ajustada para: " + novaIntensidade;
    }

    public String LuzDeFreio() {
        return luzDeFreioLigada;
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
