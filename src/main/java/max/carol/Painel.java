package max.carol;

import java.util.ArrayList;
import java.util.List;

public class Painel {
    private String tipo;
    private String display;
    private boolean controle;
    private String marca;
    private boolean estado;
    private List<String> mensagens;             // Mensagens atuais no painel
    private List<String> historicoDeMensagens;  // Histórico completo de mensagens

    public Painel(String tipo, String display, boolean controle, String marca, boolean estado) {
        this.tipo = tipo;
        this.display = display;
        this.controle = controle;
        this.marca = marca;
        this.estado = estado;
        this.mensagens = new ArrayList<>();
        this.historicoDeMensagens = new ArrayList<>();
    }

    public void ligarDisplay() {
        this.estado = true;
        System.out.println("O display do painel " + marca + " está ligado.");
    }

    public void desligarDisplay() {
        this.estado = false;
        System.out.println("O display do painel " + marca + " está desligado.");
    }

    public void atualizarInformacoes(String info) {
        if (!estado) {
            System.out.println("O display está desligado. Não é possível atualizar as informações.");
            return;
        }
        this.display = info;
        mensagens.add(info);
        historicoDeMensagens.add(info);
        System.out.println("As informações do painel " + marca + " foram atualizadas para: " + display);
    }

    public void adicionarMensagem(String mensagem) {
        if (!estado) return;
        mensagens.add(mensagem);
        historicoDeMensagens.add(mensagem);
        System.out.println("Painel: " + mensagem);
    }

    public void limparMensagens() {
        mensagens.clear();
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

    public List<String> getMensagens() {
        return new ArrayList<>(mensagens); 
    }

    public List<String> getHistoricoDeMensagens() {
        return new ArrayList<>(historicoDeMensagens); // Protege contra alterações externas
    }
    public List<String> getHistoricoDeVelocidade() {
    return new ArrayList<>(historicoDeMensagens); // Retorna uma cópia para evitar alterações externas
}


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
