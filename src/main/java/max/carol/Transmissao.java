package max.carol;

import java.util.Map;

public class Transmissao {

    public enum Tipos {
        MarchaManual,
        MarchaAutomatica
    }

    // Supondo só manual para seu teste
    public enum MarchaManual {
        R, N, M1, M2, M3, M4, M5;
    }

    public enum MarchaAutomatica {
        P, R, N, D;
    }

    // Enum pública para uso no teste e fora da classe
    public enum Marcha {
        PRIMEIRA,
        SEGUNDA,
        TERCEIRA,
        QUARTA,
        QUINTA
    }

    private Tipos tipo;
    private int numeroDeMarchas;
    private String material;
    private String marca;
    private boolean estado;
    private MarchaManual marchaManual;
    private MarchaAutomatica marchaAutomatica;
    final public Map<Marcha, Integer> mapaMarchaParaInt = Map.of(
            Marcha.PRIMEIRA, 1,
            Marcha.SEGUNDA, 2,
            Marcha.TERCEIRA, 3,
            Marcha.QUARTA, 4,
            Marcha.QUINTA, 5);

    // Limites máximos de velocidade para cada marcha (exemplo hipotético)
    final public Map<Marcha, Integer> velocidadeEsperada = Map.of(
            Marcha.PRIMEIRA, 20,
            Marcha.SEGUNDA, 40,
            Marcha.TERCEIRA, 60,
            Marcha.QUARTA, 90,
            Marcha.QUINTA, 120);

    public Transmissao(Tipos tipo, int numeroDeMarchas, String material, String marca) {
        this(tipo, numeroDeMarchas, material, marca, true);
    }

    public Transmissao(Tipos tipo, int numeroDeMarchas, String material, String marca, boolean estado) {
        this.tipo = tipo;
        this.numeroDeMarchas = numeroDeMarchas;
        this.material = material;
        this.marca = marca;
        this.estado = estado;

        if (tipo == Tipos.MarchaManual) {
            this.marchaManual = MarchaManual.N;
        } else if (tipo == Tipos.MarchaAutomatica) {
            this.marchaAutomatica = MarchaAutomatica.N;
        }
    }

    // Novo método para trocar marcha usando enum Marcha
    public void trocarMarcha(Marcha marcha) {
        if (!estado) {
            throw new IllegalStateException(
                    "Sistema de transmissão fora de funcionamento. Não é possível trocar a marcha.");
        }
        if (tipo != Tipos.MarchaManual) {
            throw new UnsupportedOperationException("Apenas transmissão manual suportada para troca por enum Marcha");
        }
        if (numeroDeMarchas < 5) {
            throw new IllegalStateException("Número de marchas incompatível com a enum Marcha");
        }

        switch (marcha) {
            case PRIMEIRA -> marchaManual = MarchaManual.M1;
            case SEGUNDA -> marchaManual = MarchaManual.M2;
            case TERCEIRA -> marchaManual = MarchaManual.M3;
            case QUARTA -> marchaManual = MarchaManual.M4;
            case QUINTA -> marchaManual = MarchaManual.M5;
            default -> throw new IllegalArgumentException("Marcha inválida");
        }
        System.out.println("Marcha trocada para: " + marcha.name());
    }

    // Método para obter a marcha atual como enum Marcha
    public Marcha getMarchaAtual() {
        if (tipo != Tipos.MarchaManual) {
            return null; // Ou lançar exceção, conforme seu projeto
        }

        return switch (marchaManual) {
            case M1 -> Marcha.PRIMEIRA;
            case M2 -> Marcha.SEGUNDA;
            case M3 -> Marcha.TERCEIRA;
            case M4 -> Marcha.QUARTA;
            case M5 -> Marcha.QUINTA;
            default -> null; // para N, R e outros
        };
    }

    // Mantendo o método original para compatibilidade
    public String trocarMarcha(int marcha) {
        if (!estado) {
            throw new IllegalStateException(
                    "Sistema de transmissão fora de funcionamento. Não é possível trocar a marcha.");
        }

        if (marcha >= 1 && marcha <= numeroDeMarchas) {
            if (tipo == Tipos.MarchaManual) {
                switch (marcha) {
                    case 1 -> marchaManual = MarchaManual.M1;
                    case 2 -> marchaManual = MarchaManual.M2;
                    case 3 -> marchaManual = MarchaManual.M3;
                    case 4 -> marchaManual = MarchaManual.M4;
                    case 5 -> marchaManual = MarchaManual.M5;
                    default -> throw new IllegalArgumentException("Marcha inválida");
                }
            } else if (tipo == Tipos.MarchaAutomatica) {
                switch (marcha) {
                    case 1 -> marchaAutomatica = MarchaAutomatica.D;
                    case 2 -> marchaAutomatica = MarchaAutomatica.R;
                    case 3 -> marchaAutomatica = MarchaAutomatica.N;
                    case 4 -> marchaAutomatica = MarchaAutomatica.P;
                    default -> throw new IllegalArgumentException("Marcha inválida");
                }
            }
            System.out.println("Marcha trocada para: " + marcha);
            return "Marcha trocada para: " + marcha;
        } else {
            throw new IllegalArgumentException(
                    "Marcha inválida. O número de marchas disponíveis é: " + numeroDeMarchas);
        }
    }

    // Outros métodos mantidos

    public void verificarEstado() {
        if (estado) {
            System.out.println("Sistema de transmissão funcionando corretamente.");
        } else {
            System.out.println("Sistema de transmissão fora de funcionamento.");
        }
    }

    public void substituirComponente(String componente) {
        if (!estado) {
            System.out.println("Substituindo componente: " + componente);
            estado = true;
            System.out.println("Sistema de transmissão funcionando novamente.");
        } else {
            System.out.println("Sistema de transmissão já está funcionando. Nenhuma substituição necessária.");
        }
    }

    public void falharSistema() {
        this.estado = false;
    }

    public Tipos getTipo() {
        return this.tipo;
    }

    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    public String getMaterial() {
        return material;
    }

    public String getMarca() {
        return marca;
    }

    // Retorna marcha manual ou automática, mas melhor usar getMarchaAtual()
    public Object getMarcha() {
        return marchaManual != null ? marchaManual : marchaAutomatica;
    }

    public boolean isEstado() {
        return estado;
    }
}
