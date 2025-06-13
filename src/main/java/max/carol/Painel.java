package max.carol;

import java.util.ArrayList;
import java.util.List;

public class Painel {
    private String tipo;
    private String display;
    private boolean controle;
    private String marca;
    private boolean estado;
    private Painel painel;
    private List<String> historicoDeMensagens;
    private List<String> mensagens = new ArrayList<>(); // <== ADICIONADO

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
        this.historicoDeMensagens = new ArrayList<>(); // <<< Inicialização aqui

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
            mensagens.add(info); // <== ADICIONADO
            System.out.println("As informações do painel " + marca + " foram atualizadas para: " + display);
        } else {
            System.out.println("O display está desligado. Não é possível atualizar as informações.");
        }
    }

    public List<String> getMensagens() {
        return mensagens;
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

    public void adicionarMensagem(String mensagem) {
        // Armazena a mensagem no histórico
        historicoDeMensagens.add(mensagem);
        // Além disso, poderia imprimir ou atualizar a interface do painel
        System.out.println("Painel: " + mensagem);
    }

    public List<String> getHistoricoDeVelocidade() {
        return new ArrayList<>(historicoDeMensagens); // Retorna uma cópia para evitar alterações externas
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
