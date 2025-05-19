package max.carol;

import java.util.List;

public class Portas {
    private int quantidade;
    private String material;
    private String cor;
    private String tipo;
    private String estado;

    public Portas(int quantidade, String material, String cor, String tipo, String estado) {
        this.quantidade = quantidade;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void abrir() {
        if (estado.equals("fechada")) {
            estado = "aberta";
            System.out.println("A porta foi aberta.");
        } else {
            System.out.println("A porta já está aberta.");
        }
    }

    public void fechar() {
        if (estado.equals("aberta")) {
            estado = "fechada";
            System.out.println("A porta foi fechada.");
        } else {
            System.out.println("A porta já está fechada.");
        }
    }

    public String verificarEstado() {
        return "A porta está " + estado + ".";
    }

    // Métodos auxiliares para testes

    public String[] getTiposDisponiveis() {
        return new String[]{"corrediça", "suicida", "asa de gaivota"};
    }

    public List<String> getRegrasSeguranca() {
        return List.of(
            "Mantenha as portas travadas em movimento",
            "Não abra as portas com o carro em movimento",
            "Verifique se as portas estão fechadas antes de sair"
        );
    }

    public String getManualUso() {
        return "1. Verifique a trava\n2. Puxe a maçaneta\n3. Empurre suavemente";
    }

    public Portas getPortaDeReparo() {
        return null;
    }

    public void erroFechamento() {
        throw new IllegalStateException("Erro ao tentar fechar a porta!");
    }

    public void abrirDemoradamente() {
        try {
            Thread.sleep(900);
        } catch (InterruptedException ignored) {}
    }

    // Getters

    public int getQuantidade() {
        return quantidade;
    }

    public String getMaterial() {
        return material;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
}
