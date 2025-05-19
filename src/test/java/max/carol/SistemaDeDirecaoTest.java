package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaDeDirecaoTest {

    SistemaDeDirecao direcao = new SistemaDeDirecao("Hidráulica", true, "Aço", 14.5, "ZF");

    @Test
    public void testAjustarDirecao() {
        direcao.ajustarDirecao(30.0);
        assertEquals("Sistema de direção em bom estado.", direcao.verificarEstado());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"Volante", "Caixa de direção", "Coluna", "Bomba hidráulica"};
        assertArrayEquals(esperado, direcao.getComponentesPrincipais());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of(
            "Verificar fluido de direção",
            "Inspecionar folgas no volante",
            "Checar bomba hidráulica"
        );
        assertIterableEquals(esperado, direcao.getChecklistManutencao());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
            "1. Gire o volante suavemente",
            "2. Evite manobras bruscas",
            "3. Mantenha manutenção em dia"
        );
        List<String> atual = List.of(direcao.getInstrucoesDeManuseio().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(direcao.getDirecaoReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> direcao.simularFalhaGrave());
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> direcao.testeDemorado());
    }
}
