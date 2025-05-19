package max.carol;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SuspensaoTest {

    @Test
    public void testAjustarAltura() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        suspensao.ajustarAltura(20.0);
        assertEquals(20.0, suspensao.getAltura(), "Altura deve ser ajustada para 20.0");
    }

    @Test
    public void testVerificarEstado() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        String estado = suspensao.verificarEstado();

        List<String> expectedLines = Arrays.asList("Suspensão em .* estado\\.");
        List<String> actualLines = Arrays.asList(estado);

        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    public void testSubstituir() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");

        assertTimeout(Duration.ofMillis(100), () -> {
            suspensao.substituir();
        });
    }

    @Test
    public void testAssertArrayEquals() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        assertArrayEquals(
            suspensao.getNomesGetters(),
            new String[] { "getTipo", "getMaterial", "getMarca" },
            "Arrays devem ser iguais"
        );
    }

    @Test
    public void testAssertIterableEquals() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        List<Object> expected = Arrays.asList("TipoA", "Aço", "MarcaX");
        List<Object> actual = Arrays.asList(suspensao.getValoresAtributos());
        assertIterableEquals(expected, actual, "Iteráveis devem ser iguais");
    }

    @Test
    public void testAssertNull() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        assertNull(suspensao.metodoQueRetornaNull(), "O método deve retornar null");
    }

    @Test
    public void testAssertThrows() {
        Suspensao suspensao = new Suspensao("TipoA", "Aço", 15.0, 7, "MarcaX");
        Executable executavel = () -> suspensao.metodoQueLancaExcecao();
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, executavel, "Deve lançar IllegalArgumentException");
        assertEquals("Erro simulado", excecao.getMessage());
    }
}
