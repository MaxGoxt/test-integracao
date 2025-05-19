package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FreiosTest {

    Freios freios = new Freios("disco", "aço", 30.5, "Brembo", 45.7);

    @Test
    public void testVerificarDesgaste() {
        assertEquals(45.7, freios.verificarDesgaste());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"disco", "tambor", "hidráulico"};
        assertArrayEquals(esperado, freios.getTiposDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("Brembo", "Bosch", "TRW");
        assertIterableEquals(esperado, freios.getMarcasRecomendadas());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
                "1. Verifique o desgaste",
                "2. Substitua as pastilhas",
                "3. Ajuste o sistema"
        );
        List<String> atual = List.of(freios.getManualFreio().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(freios.getFreioReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> {
            freios.ajustarComErro();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            freios.operacaoDemorada();
        });
    }
}
