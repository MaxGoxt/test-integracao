package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemadeCombustivelTest {

    SistemaDeCombustivel combustivel = new SistemaDeCombustivel("Gasolina", 50.0, 20.0, "Bosch", true);

    @Test
    public void testAbastecerValido() {
        combustivel.abastecer(10.0);
        assertEquals(30.0, combustivel.verificarNivel(), 0.01);
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"Gasolina", "Etanol", "Diesel", "GNV"};
        assertArrayEquals(esperado, combustivel.getTiposDeCombustivelDisponiveis());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of(
            "Não fume durante o abastecimento",
            "Desligue o motor ao abastecer",
            "Evite transbordamento"
        );
        assertIterableEquals(esperado, combustivel.getRegrasDeSeguranca());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
            "1. Abra a tampa do tanque",
            "2. Insira a bomba",
            "3. Selecione o tipo de combustível",
            "4. Abasteça"
        );
        List<String> atual = List.of(combustivel.getInstrucoesDeUso().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(combustivel.getTanqueReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(RuntimeException.class, () -> combustivel.causarFalhaNoTanque());
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> combustivel.abastecimentoDemorado());
    }
}
