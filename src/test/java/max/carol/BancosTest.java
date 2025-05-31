package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BancosTest {

    Bancos bancos = new Bancos(5, "couro", "preto", "esportivo", "novo");

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"couro", "tecido", "sintético"};
        assertArrayEquals(esperado, bancos.getMateriaisDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("preto", "cinza", "bege");
        assertIterableEquals(esperado, bancos.getCoresDisponiveis());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
                "1. Ajuste o encosto",
                "2. Ajuste a altura",
                "3. Verifique o estado"
        );
        List<String> atual = List.of(bancos.getManual().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(bancos.getBancoSubstituto());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            bancos.ajustarAlturaInvalida();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            bancos.operacaoLenta();
        });
    }
}
