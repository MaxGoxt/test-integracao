package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PneusTest {

    Pneus pneus = new Pneus("R16", "All-Terrain", 32.0, "Michelin", "Bom");

    @Test
    public void testAjustarPressao() {
        pneus.ajustarPressao(35.0);
        assertEquals(35.0, pneus.getPressao());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"Pirelli", "Michelin", "Goodyear"};
        assertArrayEquals(esperado, pneus.getModelosDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of(
            "Verifique a pressão semanalmente",
            "Evite buracos",
            "Substitua a cada 50.000 km"
        );
        assertIterableEquals(esperado, pneus.getAvisosDeUso());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
            "1. Calibre os pneus",
            "2. Use o bico correto",
            "3. Verifique o desgaste"
        );
        List<String> atual = List.of(pneus.getManualUso().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(pneus.getEstepeReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> {
            pneus.falhaPneu();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            pneus.calibragemDemorada();
        });
    }
}
