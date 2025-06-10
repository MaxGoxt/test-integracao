package max.carol;

import java.util.List;

public class Painel {
    private String tipo;
    private String display;
    private boolean controle;
    private String marca;
    private boolean estado;

    public Painel(
            String tipo,
            String display,
            boolean controle,
            String marca,
            boolean estado) {
        this.tipo = tipo;
        this.display = display;
        this.controle = controle;
        this.marca = marca;
        this.estado = estado;
    }

    public void ligarDisplay() {
        estado = true;
        System.out.println("O display do painel " + marca + " está ligado.");
    }

    public void desligarDisplay() {
        estado = false;
        System.out.println("O display do painel " + marca + " está desligado.");
    }

    public void atualizarInformacoes(String info) {
        if (estado) {
            display = info;
            System.out.println("As informações do painel " + marca + " foram atualizadas para: " + display);
        } else {
            System.out.println("O display está desligado. Não é possível atualizar as informações.");
        }
    }

    // Métodos auxiliares para testes

    public List<String> getHistoricoDeMensagens() {
        return List.of("Porta aberta", "Cinto desatado", "Revisão próxima");
    }

    public void simularFalha() {
        throw new IllegalStateException("Erro crítico no painel!");
    }

    public void operacaoDemorada() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException ignored) {
        }
    }

    // Getters

    public String getTipo() {
        return tipo;
    }

    public String getDisplay() {
        return display;
    }

    public boolean isControle() {
        return controle;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isEstado() {
        return estado;
    }
}
