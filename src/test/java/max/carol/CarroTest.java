import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import max.carol.Transmissao.Tipos;

import java.time.Duration;
import java.util.List;

public class CarroTest {

    private Carro carro;
    private Pneus pneuDianteEsquerdo;
    private Pneus pneuDianteiroDireito;
    private Pneus pneuTraseiroEsquerdo;
    private Pneus pneuTraseiroDireito;
    private Transmissao transmissao;

    @BeforeEach
    void setUp() {
        transmissao = new Transmissao(Tipos.MarchaAutomatica);

        pneuDianteEsquerdo = new Pneus("16", "Radial", 32.0, "Pirelli", "Novo", Pneus.posicaoPneu.DIANTEIRO_ESQUERDO);
        pneuDianteiroDireito = new Pneus("16", "Radial", 32.0, "Pirelli", "Novo", Pneus.posicaoPneu.DIANTEIRO_DIREITO);
        pneuTraseiroEsquerdo = new Pneus("16", "Radial", 32.0, "Pirelli", "Novo", Pneus.posicaoPneu.TRASEIRO_ESQUERDO);
        pneuTraseiroDireito = new Pneus("16", "Radial", 32.0, "Pirelli", "Novo", Pneus.posicaoPneu.TRASEIRO_DIREITO);

        carro = new Carro("ModeloX", 2020, "Preto", "ABC1234", 10000.0,
                transmissao,
                pneuDianteEsquerdo, pneuDianteiroDireito,
                pneuTraseiroEsquerdo, pneuTraseiroDireito);

        carro.sistemaEletrico = new SistemaEletrico(12.0, 60.0, "Ácido-Chumbo", true, "Bosch");
        carro.sistemaDeCombustivel = new SistemaDeCombustivel("Gasolina", 50.0, 30.0, "Petrobras", true);
        carro.motor = new Motor("V6", 200, 3.5, "Fiat", true);
        carro.transmissao = transmissao;
        carro.velocidadeMaxima = 120;
    }

    @Test
    void testAssertArrayEquals() {
        Pneus[] esperado = { pneuDianteEsquerdo, pneuDianteiroDireito, pneuTraseiroEsquerdo, pneuTraseiroDireito };
        assertArrayEquals(esperado, carro.pneus.toArray(), "Os pneus devem estar nas posições corretas.");
    }

    @Test
    void testAssertIterableEquals() {
        List<Pneus> esperado = List.of(pneuDianteEsquerdo, pneuDianteiroDireito, pneuTraseiroEsquerdo,
                pneuTraseiroDireito);
        assertIterableEquals(esperado, carro.pneus, "As listas de pneus devem ser iguais.");
    }

    @Test
    void testAssertLinesMatch() {
        List<String> esperado = List.of("Carro acelerando...");
        carro.ligar();
        String resultado = carro.acelerar();
        assertLinesMatch(esperado, List.of(resultado), "As mensagens devem coincidir.");
    }

    @Test
    void testAssertNull() {
        carro.motor = null; // força motor como nulo
        Exception ex = assertThrows(NullPointerException.class, () -> carro.ligar());
        assertNull(ex.getCause(), "A exceção não deve ter causa.");
    }

    @Test
    void testAssertThrows() {
        carro.sistemaDeCombustivel = new SistemaDeCombustivel(0);
        Exception ex = assertThrows(IllegalStateException.class, () -> carro.ligar());
        assertEquals("Tanque de combustível está vazio.", ex.getMessage());
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            carro.ligar();
            carro.acelerar();
        }, "O método deve executar rapidamente.");
    }
}
