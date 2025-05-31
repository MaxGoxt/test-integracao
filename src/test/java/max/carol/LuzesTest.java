package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LuzesTest {

    Luzes luzes = new Luzes("farol", 70, "branca", false, "LED");

    @Test
    public void testLigar() {
        luzes.ligar();
        assertTrue(luzes.isEstado());
    }

    @Test
    public void testDesligar() {
        luzes.desligar();
        assertFalse(luzes.isEstado());
    }

    @Test
    public void testAjustarIntensidade() {
        luzes.ajustarIntensidade(90);
        assertEquals(90, luzes.getIntensidade());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"branca", "amarela", "azul"};
        assertArrayEquals(esperado, luzes.getCoresDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("LED", "Xênon", "Halógena");
        assertIterableEquals(esperado, luzes.getModelosDisponiveis());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
                "1. Ligue as luzes",
                "2. Ajuste a intensidade",
                "3. Verifique a cor"
        );
        List<String> atual = List.of(luzes.getManualLuzes().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(luzes.getLuzReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            luzes.ajustarErro();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            luzes.operacaoDemorada();
        });
    }
}
