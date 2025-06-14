package max.carol;

import java.util.List;

import max.carol.Transmissao.MarchaManual;
import max.carol.Transmissao.Tipos;

public class Carro {
    /*
     * 1. Carro
     * Atributos:
     * • modelo (String)
     * • ano (int)
     * • cor (String)
     * • placa (String)
     * • quilometragem (double)
     * Métodos:
     * • ligar(): Liga o carro.
     * • desligar(): Desliga o carro.
     * • atualizarQuilometragem(double km): Atualiza a quilometragem do carro.
     */

    public String modelo;
    public int ano;
    public String cor;
    public String placa;
    public double quilometragem;
    public boolean ligado;
    public Integer velocidade = 0; // Velocidade inicial do carro
    public Integer velocidadeMaxima;
    public Bancos bancos;
    public Freios freios;
    public Luzes luzes;
    public Motor motor;
    public Painel painel;
    public List<Pneus> pneus; // Array de pneus
    public SistemaDeCombustivel sistemaDeCombustivel;
    public SistemaDeDirecao sistemaDeDirecao;
    public SistemaEletrico sistemaEletrico;
    public Suspensao suspensao;
    public Transmissao transmissao;
    public Portas portas; // Adicionando o atributo portas

    public static void main(String[] args) {
        System.out.println("Carro.java");
    }

    public Carro(
            String modelo,
            int ano,
            String cor,
            String placa,
            double quilometragem,
            Transmissao transmissao,
            Motor motor,
            Suspensao suspensao,
            Painel painel,
            SistemaEletrico sistemaEletrico,
            SistemaDeDirecao sistemaDeDirecao,
            SistemaDeCombustivel sistemaDeCombustivel,
            Luzes luzes,
            Freios freios,
            Bancos bancos,
            Pneus pneuDianteEsquerdo,
            Pneus pneuDianteiroDireito,
            Pneus pneuTraseiroEsquerdo,
            Pneus pneuTraseiroDireito,
            Portas portas) {

        if (modelo == null || modelo.isEmpty()) {
            throw new NullPointerException("Modelo não pode ser nulo ou vazio.");
        }
        if (ano <= 1885) { // O primeiro carro foi inventado em 1886
            throw new NullPointerException("Ano inválido para o carro.");
        }
        if (cor == null || cor.isEmpty()) {
            throw new NullPointerException("Cor não pode ser nula ou vazia.");
        }
        if (placa == null || placa.isEmpty()) {
            throw new NullPointerException("Placa não pode ser nula ou vazia.");
        }
        if (quilometragem < 0) {
            throw new IllegalArgumentException("Quilometragem não pode ser negativa.");
        }
        if (pneuDianteEsquerdo == null || pneuDianteiroDireito == null || pneuTraseiroEsquerdo == null
                || pneuTraseiroDireito == null) {
            throw new NullPointerException("Todos os pneus devem ser fornecidos.");
        }
        if (pneuDianteEsquerdo.getPosicao() != Pneus.posicaoPneu.DIANTEIRO_ESQUERDO ||
                pneuDianteiroDireito.getPosicao() != Pneus.posicaoPneu.DIANTEIRO_DIREITO ||
                pneuTraseiroEsquerdo.getPosicao() != Pneus.posicaoPneu.TRASEIRO_ESQUERDO ||
                pneuTraseiroDireito.getPosicao() != Pneus.posicaoPneu.TRASEIRO_DIREITO) {
            throw new IllegalArgumentException("Pneus devem estar nas posições corretas.");
        }
        if (transmissao == null) {
            throw new NullPointerException("Transmissão não pode ser nula.");
        }
        if (motor == null) {
            throw new NullPointerException("Motor não pode ser nulo.");
        }
        if (sistemaEletrico == null) {
            throw new NullPointerException("Sistema elétrico não pode ser nulo.");
        }
        if (sistemaDeCombustivel == null) {
            throw new NullPointerException("Sistema de combustível não pode ser nulo.");
        }
        if (bancos == null) {
            throw new NullPointerException("Bancos não podem ser nulos.");
        }

        this.pneus = List.of(pneuDianteEsquerdo, pneuDianteiroDireito, pneuTraseiroEsquerdo, pneuTraseiroDireito);
        this.sistemaDeCombustivel = sistemaDeCombustivel;
        this.sistemaEletrico = sistemaEletrico;
        this.quilometragem = quilometragem;
        this.transmissao = transmissao;
        this.modelo = modelo;
        this.ligado = false;
        this.motor = motor;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.bancos = bancos;
        this.freios = freios;
        this.luzes = luzes;
        this.sistemaDeDirecao = sistemaDeDirecao;
        this.suspensao = suspensao;
        this.painel = painel;
        this.velocidadeMaxima = 200;
        this.portas = portas;
    }

    // public void ligar() {

    // if (sistemaEletrico == null) {
    // throw new NullPointerException("Sistema elétrico não está disponível.");
    // }
    // if (!sistemaEletrico.isEstadoOk()) {
    // throw new IllegalStateException("Bateria está descarregada.");
    // }

    // if (sistemaDeCombustivel == null) {
    // throw new NullPointerException("Sistema de combustível não está
    // disponível.");
    // }

    // if (sistemaDeCombustivel.getNivelDeCombustivel() <= 0) {
    // throw new IllegalStateException("Tanque de combustível está vazio.");
    // }

    // if (motor == null) {
    // throw new NullPointerException("Motor não está disponível.");
    // }

    // if (transmissao == null) {
    // throw new NullPointerException("Transmissão não está disponível.");
    // }

    // if (!ligado) {
    // ligado = true;
    // System.out.println("Carro ligado.");
    // } else {
    // System.out.println("Carro já está ligado.");
    // }
    // }

    // public String desligar() {
    // if (ligado) {
    // ligado = false;
    // velocidade = 0;
    // return "Carro desligado.";
    // } else {
    // return "Carro já está desligado.";
    // }
    // }

    // public void atualizarQuilometragem(double km) {
    // if (km > 0) {
    // this.quilometragem += km;
    // System.out.println("Quilometragem atualizada para: " + this.quilometragem);
    // } else {
    // System.out.println("Valor de quilometragem inválido.");
    // }
    // }

    // public String acelerar() {

    // if (!ligado) {
    // return "Carro desligado. Ligue o carro antes de acelerar.";
    // }

    // if (velocidade >= velocidadeMaxima) {
    // return "Velocidade máxima atingida. Não é possível acelerar mais.";
    // }

    // if (transmissao == null) {
    // return "Transmissão não está disponível. Não é possível acelerar.";
    // }

    // if (transmissao.getTipo() == Tipos.MarchaAutomatica) {
    // velocidade += 10;
    // return "Carro acelerando...";
    // }

    // if (transmissao.getTipo() == Tipos.MarchaManual && transmissao.getMarcha() ==
    // MarchaManual.N) {
    // return "Carro em ponto morto. Mude a marcha para acelerar.";
    // }

    // velocidade += 10;
    // return "Carro acelerando...";
    // }

    // public String frear() {

    // if (!ligado) {
    // return "Carro desligado.";
    // }

    // if (velocidade <= 0) {
    // return "Carro já está parado.";
    // }

    // if (freios == null) {
    // return "Sistema de freios não está disponível. Não é possível frear.";
    // }

    // velocidade -= 10;
    // if (velocidade < 0) {
    // velocidade = 0;
    // }
    // return "Carro freando...";
    // }

    // public String buzinar() {
    // if (!ligado) {
    // return "Carro desligado. Ligue o carro para buzinar.";
    // }
    // return "Buzina acionada!";
    // }

    // public String getvelocidade() {
    // return "Velocidade atual: " + velocidade + " km/h";
    // }

    ////////////////////////////////////////////////////////////////////

    public void ligar() {

        if (this.sistemaEletrico == null) {
            throw new NullPointerException("Sistema elétrico não pode ser nulo.");
        }

        if (this.sistemaEletrico.getNivelCarga() < 30) {
            if (painel != null) {
                painel.ligarDisplay(); // liga o display para mostrar a mensagem
                painel.atualizarInformacoes("Erro: Bateria insuficiente");
            }

            this.ligado = false;
            return;
        }

        if (this.portas.temPortaAberta()) {
            this.painel.atualizarInformacoes("Alerta: Porta aberta");
            throw new IllegalStateException("Não é possível ligar o carro com portas abertas.");
        }

        if (this.motor != null) {
            this.motor.ligar();
        } else {
            throw new NullPointerException("Motor não pode ser nulo.");
        }

        if (this.painel != null) {
            this.painel.ligarDisplay();
            this.painel.atualizarInformacoes("Painel ativo");
        } else {
            this.motor.desligar();
            throw new NullPointerException("Painel não pode ser nulo.");
        }

        this.ligado = true;
        System.out.println("Carro ligado.");
    }

   public String desligar() {
    if (ligado) {
        ligado = false;
        velocidade = 0;

        if (luzes != null && luzes.areFaroisAcesos() && painel != null) {
            painel.atualizarInformacoes("Alerta: Faróis ligados");
        }

        return "Carro desligado.";
        
    } else {
        return "Carro já está desligado.";
    }
}


    public void acelerar() {
        if (!this.ligado || this.motor == null || !this.motor.isLigado()) {
            painel.atualizarInformacoes("Carro desligado ou motor inativo.");
            throw new IllegalStateException("Carro desligado ou motor inativo.");
        }

        if (this.portas != null && this.portas.temPortaAberta()) {
            painel.atualizarInformacoes("Alerta: Porta aberta");
            painel.atualizarInformacoes("Movimento bloqueado");
            throw new IllegalStateException("Porta aberta. Não é possível acelerar.");
        }

        if (this.sistemaDeCombustivel.getNivelDeCombustivel() > 0) {
            if (this.velocidade >= this.velocidadeMaxima) {
                painel.atualizarInformacoes("Velocidade máxima alcançada.");
                return;
            }

            this.sistemaDeCombustivel.consumir(1);
            this.velocidade += 10;
            painel.atualizarInformacoes("Acelerando...");
            System.out.println("Acelerando...");
        } else {
            painel.atualizarInformacoes("Sem combustível.");
            System.out.println("Não há combustível.");
        }
    }

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

    public SistemaEletrico getSistemaEletrico() {
        return this.sistemaEletrico;
    }

    public Bancos getBancos() {
        return bancos;
    }

    public void setBancos(Bancos bancos) {
        this.bancos = bancos;
    }

    public Painel getPainel() {
        return painel;
    }

    public Integer getVelocidade() {
        return this.velocidade;
    }

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
