package max.carol;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import max.carol.Transmissao.Marcha;

public class CarroTest {

        private SistemaDeDirecao direcao;
        private SistemaEletrico eletrico;
        private Pneus pneu;
        private Bancos banco;
        private SistemaDeCombustivel combustivel;
        private Carro carro;
        private Motor motor;
        private Luzes luzes;
        private Freios freio;
        private Portas portas;
        private Suspensao suspensao;
        private Painel painel;
        private Transmissao transmissao;

        @BeforeEach
        public void setUp() {
                // Inicializa os componentes necessários para o teste do carro
                direcao = new SistemaDeDirecao();
                eletrico = new SistemaEletrico(true);
                pneu = new Pneus(Pneus.posicaoPneu.DIANTEIRO_ESQUERDO);
                banco = new Bancos(5, "bom", "Couro", "preto", "Couro Sintético");
                combustivel = new SistemaDeCombustivel("algo", 5, 50, "Ipiranga", true);
                freio = new Freios("Disco", "Aço", 15.0, "Bosch", 10.0, false);
                luzes = new Luzes("Luz de posição", 100, "branca", true, "luzes de posição", "true");
                portas = new Portas(4, "Aço", "Preto", "corrediça", "fechada", "fechada");
                painel = new Painel("Digital", "Inicializando", true, "MarcaX", true);
                motor = new Motor("Gasolina", 100, 1.6, "Honda", true);
                suspensao = new Suspensao("independente", "aço", 15.0, 5, "MarcaGenérica");
                transmissao = new Transmissao(Transmissao.Tipos.MarchaManual, 5, "Aço", "ZF");
                // Criação do carro com mocks básicos
                carro = new Carro(
                                "Fiat Uno",
                                2020,
                                "Preto",
                                "ABC-1234",
                                50000,
                                new Transmissao(Transmissao.Tipos.MarchaManual, 5, "Aço", "ZF"),
                                new Motor("algo", 50, 50, "Rossi", true),
                                new Suspensao("independente", "aço", 15.0, 5, "MarcaGenérica"),
                                new Painel("Digital", "Inicializando", true, "Genérico", false),
                                eletrico,
                                direcao,
                                combustivel,
                                new Luzes("Luz de posição", 100, "branca", true, "luzes de posição", "true"),
                                new Freios("ABS", "butadieno, do estireno e da acrilonitrila", 20, "Bosch ", 20, true),
                                banco,
                                new Pneus(Pneus.posicaoPneu.DIANTEIRO_ESQUERDO),
                                new Pneus(Pneus.posicaoPneu.DIANTEIRO_DIREITO),
                                new Pneus(Pneus.posicaoPneu.TRASEIRO_ESQUERDO),
                                new Pneus(Pneus.posicaoPneu.TRASEIRO_DIREITO),
                                portas);
        }

        // Deve Ativar Motor Painel E Sistema Eletrico
        @Test
        void ligarCarro() {
                // Arrange
                SistemaEletrico sistemaEletrico = new SistemaEletrico(true); // Bateria ok
                Motor motor = new Motor("V8", 300, 4.0, "Chevrolet", false);
                Painel painel = new Painel("Digital", "Inicializando...", true, "Bosch", false);

                // Act
                carro.ligar();
                motor.ligar(); // simulando o motor sendo ativado pelo carro
                painel.ligarDisplay();
                painel.atualizarInformacoes("Motor ligado");

                // Assert
                assertAll("Verificação integrada dos sistemas ao ligar",
                                () -> assertTrue(motor.isLigado(), "Motor deveria estar ligado"),
                                () -> assertTrue(sistemaEletrico.isEstadoOk(), "Sistema elétrico deveria estar ativo"),
                                () -> assertEquals("Motor ligado", painel.getDisplay(),
                                                "Painel deveria mostrar mensagem 'Motor ligado'"),
                                () -> assertTrue(carro.isLigado(), "Carro deveria estar ligado"));
        }

        // _Deve Consumir Combustivel E Verificar Motor Transmissao
        @Test
        void acelerar() {

                // Act: ligar o carro e preparar o sistema para aceleração
                carro.ligar(); // Deve ligar o motor e os demais sistemas automaticamente
                transmissao.trocarMarcha(1); // Troca para marcha 1

                // Estado inicial
                double nivelInicial = combustivel.getNivelDeCombustivel();
                // boolean motorLigado = motor.isEstado();
                Object marchaAtual = transmissao.getMarcha();
                // List<String> mensagensAntes = carro.getPainel().getMensagens();

                // Acelerar
                carro.acelerar();

                // Assert: verificação integrada dos 3 sistemas
                assertAll("Verificando integração após aceleração",
                                () -> assertTrue(motor.isLigado(), "Motor deve continuar ligado após aceleração"),
                                () -> assertTrue(combustivel.getNivelDeCombustivel() < nivelInicial,
                                                "Combustível deve ter sido consumido"),
                                () -> assertEquals(Transmissao.MarchaManual.M1, marchaAtual,
                                                "Marcha deve permanecer em M1"),
                                () -> assertTrue(carro.getPainel().getMensagens().contains("Acelerando..."),
                                                "Painel deve exibir 'Acelerando...'"));
        }

        // verificarVelocidadeMaximaPorMarcha
        @Test
        void verificar_Velocidade_Maxima_Por_Marcha() {
                // TODO: Ajustar o teste para verificar a velocidade máxima por marcha
                // Map do enum Marcha para número da marcha
                // Ligar o carro para preparar o sistemaF
                carro.ligar();

                List<String> mensagensEsperadas = new ArrayList<>();

                for (Marcha marchaEnum : Marcha.values()) {
                        int numeroMarcha = carro.transmissao.mapaMarchaParaInt.get(marchaEnum);

                        // Troca a marcha no sistema
                        transmissao.trocarMarcha(numeroMarcha);

                        // Acelera até atingir a velocidade máxima da marcha
                        while (carro.getVelocidade() < carro.transmissao.velocidadeEsperada.get(marchaEnum)) {
                                carro.acelerar();
                                // Adiciona mensagem no painel
                                carro.painel.adicionarMensagem("Marcha " + marchaEnum.name() + " atingiu "
                                                + carro.getVelocidade() + "km/h");
                        }

                        // Verifica se a velocidade atingiu a esperada para a marcha atual
                        assertEquals(carro.transmissao.velocidadeEsperada.get(marchaEnum), carro.getVelocidade(),
                                        "Velocidade máxima na " + marchaEnum.name().toLowerCase()
                                                        + " marcha deveria ser " +
                                                        carro.transmissao.velocidadeEsperada.get(marchaEnum));
                }

                // Verifica se as mensagens no painel correspondem ao que foi esperado
                List<String> mensagensPainel = carro.painel.getHistoricoDeVelocidade();
                for (String mensagemEsperada : mensagensEsperadas) {
                        assertTrue(mensagensPainel.contains(mensagemEsperada),
                                        "Painel deve conter a mensagem: " + mensagemEsperada);
                }
        }

        // portaAbertaDeveImpedirAceleracaoEAposFecharPermitir
        @Test
        void porta_Aberta_Deve_Impedir_Aceleracao() {
                carro.portas.abrirPorta(0); // Porta aberta

                assertThrows(IllegalStateException.class, carro::acelerar,
                                "Deve lançar exceção ao tentar acelerar com porta aberta");

                carro.transmissao.trocarMarcha(Transmissao.Marcha.PRIMEIRA);

                carro.portas.fecharPorta(0); // Fecha a porta
                // Porta foi fechada automaticamente
                assertFalse(portas.temPortaAberta());

                // Segunda tentativa: deve funcionar
                carro.ligar();
                carro.acelerar();
                assertEquals(10, carro.getVelocidade());
        }

        // bateriaQuaseFracaAindaImpedeLigacaoDasLuzes
        @Test
        void bateria_fraca_desligar_luzes() {
                carro.getSistemaEletrico().setNivelCarga(25);
                carro.ligar();

                // Assert
                assertFalse(luzes.areFaroisAcesos(), "Faróis não devem acender com 25% de carga");
                assertLinesMatch(
                                List.of("Erro: Bateria insuficiente"),
                                carro.getPainel().getMensagens());

        }

        // deveEmitirAlertaSeDesligarCarroComFaroisLigados
        @Test
        void Alerta_Se_Desligar_Carro_Com_Farois_Ligados() {
                // Arrange
                carro.ligar();
                carro.luzes.ligar();

                // Act
                carro.desligar();
                // Assert
                assertAll("Verificando alerta de faróis ligados ao desligar carro",
                                () -> assertTrue(carro.luzes.areFaroisAcesos(), "Faróis ainda devem estar acesos"),
                                () -> assertTrue(carro.getPainel().getMensagens().contains("Alerta: Faróis ligados"),
                                                "Painel deve exibir alerta de faróis ligados"));
        }

}
