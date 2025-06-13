package max.carol;

import java.time.LocalDateTime;

public class Suspensao {

    private String tipo;
    private String material;
    private double altura;
    private int rigidez;
    private String marca;

    public Suspensao(
            String tipo,
            String material,
            double altura,
            int rigidez,
            String marca) {
        this.tipo = tipo;
        this.material = material;
        this.altura = altura;
        this.rigidez = rigidez;
        this.marca = marca;
    }

    public void ajustarAltura(double novaAltura) {
        this.altura = novaAltura;
    }

    public String verificarEstado() {
        return "Suspensão em bom estado.";
    }

    public void substituir() {
        System.out.println("Suspensão substituída por uma nova.");
    }

    // Métodos auxiliares para os testes

    public String[] getNomesGetters() {
        return new String[] { "getTipo", "getMaterial", "getMarca" };
    }

    public Object[] getValoresAtributos() {
        return new Object[] { tipo, material, marca };
    }

    

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public double getAltura() {
        return altura;
    }

    public int getRigidez() {
        return rigidez;
    }

    public String getMarca() {
        return marca;
    }
    
    public static class SuspensaoAtiva extends Suspensao {

        private double nivelAjuste;
        private LocalDateTime ultimoAjuste;

        public SuspensaoAtiva() {
            super("Ativa", "Titânio", 12.5, 5, "Monroe");
            this.nivelAjuste = 0;
            this.ultimoAjuste = null;
        }

        public void ajustarParaCurva(int angulo) {
            this.nivelAjuste = Math.abs(angulo) * 0.1; // cálculo simplificado
            this.ultimoAjuste = LocalDateTime.now();
            System.out.println("Suspensão ativa ajustada para curva: nível = " + nivelAjuste);
        }

        public double getNivelAjuste() {
            return nivelAjuste;
        }

        public LocalDateTime getUltimoAjuste() {
            return ultimoAjuste;
        }
    }
    
}
