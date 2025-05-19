package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PainelTest {

    Painel painel = new Painel("LCD", "Inicializando", true, "Bosch", false);

    @Test
    public void testLigarEDesligarDisplay() {
        painel.ligarDisplay();
        assertTrue(painel.isEstado());

        painel.desligarDisplay();
        assertFalse(painel.isEstado());
    }

    @Test
    public void testAtualizarInformacoesComPainelLigado() {
        painel.ligarDisplay();
        painel.atualizarInformacoes("Velocidade: 80km/h");
        assertEquals("Velocidade: 80km/h", painel.getDisplay());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"Configurações", "Multimídia", "Navegação"};
        assertArrayEquals(esperado, painel.getOpcoesDeMenu());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("Porta aberta", "Cinto desatado", "Revisão próxima");
        assertIterableEquals(esperado, painel.getHistoricoDeMensagens());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
            "1. Pressione o botão",
            "2. Aguarde 5 segundos",
            "3. Solte o botão"
        );
        List<String> atual = List.of(painel.getManual().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(painel.getPainelReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> {
            painel.simularFalha();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            painel.operacaoDemorada();
        });
    }
}
