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

    @BeforeEach
    public void setUp() {
        direcao = new SistemaDeDirecao();
        eletrico = new SistemaEletrico(true);
        pneu = new Pneus(Pneus.posicaoPneu.DIANTEIRO_ESQUERDO); 
        banco = new Bancos(5, "bom", "Couro", "preto","Couro Sintético" );
        combustivel = new SistemaDeCombustivel("algo", 5, 50,"Ipiranga", true);

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
                new Pneus(Pneus.posicaoPneu.TRASEIRO_DIREITO)
        );
    }

    // 1. assertArrayEquals - SistemaDeDirecao::ComponentesPrincipais
    @Test
    public void testComponentesPrincipaisDirecao() {
        String[] esperado = {"Volante", "Caixa de direção", "Coluna", "Bomba hidráulica"};
        assertArrayEquals(esperado, direcao.ComponentesPrincipais());
    }

    // 2. assertIterableEquals - SistemaDeDirecao::getChecklistManutencao
    @Test
    public void testChecklistManutencaoDirecao() {
        List<String> esperado = List.of(
            "Verificar fluido de direção",
            "Inspecionar folgas no volante",
            "Checar bomba hidráulica"
        );
        assertIterableEquals(esperado, direcao.getChecklistManutencao());
    }

    // 3. assertLinesMatch - SistemaEletrico::testarSistema (simulação)
    @Test
    public void testSaidaSistemaEletrico() {
        // Redirecionando saída para capturar o println
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        eletrico.testarSistema();

        List<String> esperado = List.of("Sistema elétrico testado com sucesso.");
        List<String> real = List.of(outContent.toString().trim());
        assertLinesMatch(esperado, real);
    }

    // 4. assertNull - Pneus::getEstepeReserva
    @Test
    public void testEstepeReservaPneu() {
        assertNull(pneu.getEstepeReserva());
    }

    // 5. assertThrows - Bancos::ajustarEncosto
    @Test
    public void testAjustarEncostoComValorInvalido() {
        assertThrows(IllegalStateException.class, () -> banco.ajustarEncosto(""));
    }

    // 6. assertTimeout - Carro::ligar
    @Test
    public void testLigarCarroComTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> carro.ligar());
    }
}
