package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarroTest {

    Carro carro = new Carro("volkswagen", 2000, "azul", "123abc", 3500);

    @Test
    public void testLigar() {
        carro.ligar();
        assertEquals(true, carro.isLigado());
    }

    @Test
    public void testDesligar() {
        carro.desligar();
        assertEquals(false, carro.isLigado());
    }

    @Test
    public void testAtualizarQuilometragem() {
        carro.atualizarQuilometragem(100);
        assertEquals(3600, carro.getQuilometragem());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"troca de óleo", "revisão dos freios"};
        assertArrayEquals(esperado, carro.getServicosPendentes());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("troca de óleo", "alinhamento");
        assertIterableEquals(esperado, carro.getManutencoesRecentes());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of("1. Ligue o carro", "2. Dirija com segurança");
        List<String> atual = List.of(carro.getManualUsuario().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(carro.getProximoCarro());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            carro.acelerarNegativo();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(3), () -> {
            carro.operacaoDemorada();
        });
    }
}
