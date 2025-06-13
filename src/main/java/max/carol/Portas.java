package max.carol;
import java.util.ArrayList;
import java.util.List;

public class Portas {
    private int quantidade;
    private String material;
    private String cor;
    private String tipo;
    private List<String> estadosPortas;

    public Portas(
            int quantidade,
            String material,
            String cor,
            String tipo,
            String estado,
            String estadoInicial) {
        this.quantidade = quantidade;
        this.material = material;
        this.cor = cor;
        this.tipo = tipo;
        this.estadosPortas = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            estadosPortas.add(estadoInicial); // Ex: "fechada"
        }
    }


  // Abre uma porta específica
    public void abrirPorta(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Índice de porta inválido.");
        }
        if (estadosPortas.get(indice).equals("fechada")) {
            estadosPortas.set(indice, "aberta");
            System.out.println("Porta " + indice + " foi aberta.");
        } else {
            System.out.println("Porta " + indice + " já está aberta.");
        }
    }

    // Fecha uma porta específica
    public void fecharPorta(int indice) {
        if (indice < 0 || indice >= quantidade) {
            throw new IndexOutOfBoundsException("Índice de porta inválido.");
        }
        if (estadosPortas.get(indice).equals("aberta")) {
            estadosPortas.set(indice, "fechada");
            System.out.println("Porta " + indice + " foi fechada.");
        } else {
            System.out.println("Porta " + indice + " já está fechada.");
        }
    }

    public boolean temPortaAberta() {
    for (String estado : estadosPortas) {
        if ("aberta".equalsIgnoreCase(estado)) {
            return true;
        }
    }
    return false;
}


    // Métodos auxiliares para testes

    public String[] getTiposDisponiveis() {
        return new String[] { "corrediça", "suicida", "asa de gaivota" };
    }

    public List<String> getRegrasSeguranca() {
        return List.of(
                "Mantenha as portas travadas em movimento",
                "Não abra as portas com o carro em movimento",
                "Verifique se as portas estão fechadas antes de sair");
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
        } catch (InterruptedException ignored) {
        }
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

}
