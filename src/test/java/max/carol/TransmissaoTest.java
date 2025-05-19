package max.carol;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class TransmissaoTest {

    @Test
    void testarTrocarMarchaValida() {
        Transmissao t = new Transmissao("Manual", 5, "Aço", "MarcaX");
        assertTimeout(Duration.ofMillis(100), () -> {
            t.trocarMarcha(3);
        });
    }

    @Test
    void testarTrocarMarchaInvalida() {
        Transmissao t = new Transmissao("Manual", 5, "Aço", "MarcaX");
        assertTimeout(Duration.ofMillis(100), () -> {
            t.trocarMarcha(6);  // Deve imprimir mensagem de marcha inválida sem lançar exceção
        });
    }

    @Test
    void testarEstadoInicial() {
        Transmissao t = new Transmissao("Manual", 5, "Aço", "MarcaX");
        assertTrue(t.isEstado());
    }

    @Test
    void testarSubstituirComponenteComFalha() {
        Transmissao t = new Transmissao("Manual", 5, "Aço", "MarcaX");
        t.falharSistema();  // Simula falha
        assertFalse(t.isEstado());

        assertTimeout(Duration.ofMillis(100), () -> {
            t.substituirComponente("Engrenagem");
        });

        assertTrue(t.isEstado(), "Após substituição, sistema deve voltar a funcionar.");
    }

    @Test
    void testarSubstituirComponenteSemFalha() {
        Transmissao t = new Transmissao("Manual", 5, "Aço", "MarcaX");
        assertTimeout(Duration.ofMillis(100), () -> {
            t.substituirComponente("Engrenagem");
        });
    }

    @Test
    void testarEstadoNull() {
        Transmissao t = null;
        assertNull(t);
    }
}
