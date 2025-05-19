package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PortasTest {

    Portas portas = new Portas(4, "Aço", "Preta", "corrediça", "fechada");

    @Test
    public void testAbrirPorta() {
        portas.abrir();
        assertEquals("aberta", portas.getEstado());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"corrediça", "suicida", "asa de gaivota"};
        assertArrayEquals(esperado, portas.getTiposDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of(
            "Mantenha as portas travadas em movimento",
            "Não abra as portas com o carro em movimento",
            "Verifique se as portas estão fechadas antes de sair"
        );
        assertIterableEquals(esperado, portas.getRegrasSeguranca());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
            "1. Verifique a trava",
            "2. Puxe a maçaneta",
            "3. Empurre suavemente"
        );
        List<String> atual = List.of(portas.getManualUso().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(portas.getPortaDeReparo());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> {
            portas.erroFechamento();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            portas.abrirDemoradamente();
        });
    }
}
