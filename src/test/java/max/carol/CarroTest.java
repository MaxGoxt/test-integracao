package max.carol;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        portas = new Portas(4, "Aço", "Preto", "corrediça", "fechada");
        painel = new Painel("Digital", "Inicializando", true, "MarcaX", true);
        motor = new Motor("Gasolina", 100, 1.6, "Honda", true);
        suspensao = new Suspensao("independente", "aço", 15.0, 5, "MarcaGenérica");
        
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
                new Pneus(Pneus.posicaoPneu.TRASEIRO_DIREITO));
    }

    // 1. Verifica se os componentes principais do sistema de direção estão corretos
    @Test
    public void testComponentesPrincipaisDirecao() {
        String[] esperado = { "Volante", "Caixa de direção", "Coluna", "Bomba hidráulica" };
        assertArrayEquals(esperado, direcao.ComponentesPrincipais());
    }

    // 2. Verifica se o checklist de manutenção do sistema de direção corresponde ao
    // esperado
    @Test
    public void testChecklistManutencaoDirecao() {
        List<String> esperado = List.of(
                "Verificar fluido de direção",
                "Inspecionar folgas no volante",
                "Checar bomba hidráulica");
        assertIterableEquals(esperado, direcao.getChecklistManutencao());
    }

    // 3. Verifica se a saída do teste do sistema elétrico corresponde à esperada
    @Test
    public void testSaidaSistemaEletrico() {
        // Redireciona a saída padrão para capturar o que é impresso no console
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        eletrico.testarSistema();

        List<String> esperado = List.of("Sistema elétrico testado com sucesso.");
        List<String> real = List.of(outContent.toString().trim());
        assertLinesMatch(esperado, real);
    }

    // 4. Verifica que o pneu não possui estepe reserva (espera null)
    @Test
    public void testEstepeReservaPneu() { // arrumar
        assertNull(pneu.getEstepeReserva());
    }

    // 5. Verifica se a exceção IllegalStateException é lançada ao ajustar o encosto
    // com valor inválido
    @Test
    public void testAjustarEncostoComValorInvalido() {
        assertThrows(IllegalStateException.class, () -> banco.ajustarEncosto(""));
    }

    // 6. Verifica que o método carro.ligar() executa dentro de 100 milissegundos
    @Test
    public void testLigarCarro() {

        assertNotEquals(null, carro.sistemaEletrico);
        assertNotEquals(null, carro.sistemaDeCombustivel);
        assertNotEquals(null, carro.motor);

        assertDoesNotThrow(() -> carro.ligar(), "O método ligar não deve lançar exceção.");
        assertTimeout(Duration.ofMillis(100), () -> carro.ligar());
    }

    //luzes
    @Test
    public void testAjustarIntensidadeLuz() {
        // Verifica o valor inicial da intensidade
        assertEquals(100, luzes.getIntensidade(), "A intensidade inicial não é a esperada.");

        // Ajusta a intensidade para 80
        String resultado = luzes.ajustarIntensidade(80);

        // Verifica se o método retornou a mensagem correta
        assertEquals("Intensidade ajustada para: 80", resultado, "A mensagem de intensidade não é a esperada.");

        // Verifica se a intensidade foi alterada corretamente
        assertEquals(80, luzes.getIntensidade(), "A intensidade da luz não foi ajustada corretamente.");
    }

    //teste pneu
    @Test
    public void testPneu() {
        assertEquals("Pressão ajustada com sucesso!", pneu.ajustarPressao(30));
    }

    //teste sistema de combustivel
    @Test
    public void testCombustivel() {
        assertThrows(IllegalArgumentException.class, () -> combustivel.abastecer(-10));
    }

    //teste freios
    @Test
    public void testAtivarFreioDeMao() {
        freio.ativarFreiodemao();
        assertTrue(freio.verificarfreioDeMao(), "Freio de mão não foi ativado.");
    }

    //teste motor
    @Test
    public void testMotor() {
        motor.desligar();
        assertEquals("Motor desligado.", motor.verificarEstado());
    }
    //teste portas
    @Test
    public void testQuantidadeDePortas() {
        assertEquals(4, portas.getQuantidade(), "A quantidade de portas deve ser 4.");
    }

    //teste suspensao
    @Test
    public void testVerificarEstadoSuspensao() {
        assertTrue(suspensao.verificarEstado().contains("Suspensão em bom estado."));
    }

    //teste painel
    @Test
    public void testLigarPainel() {
        assertTimeout(Duration.ofSeconds(2), () -> painel.operacaoDemorada());
    }
    
    @Test
    public void testTransmissao() {
        Transmissao transmissao = new Transmissao(Transmissao.Tipos.MarchaManual, 5, "Aço", "ZF");
        assertThrows(IllegalArgumentException.class, () -> transmissao.trocarMarcha(-5));
    }
}
