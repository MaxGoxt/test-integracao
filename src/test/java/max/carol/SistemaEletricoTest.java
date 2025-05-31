package max.carol;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SistemaEletricoTest {

    @Test
    public void testVerificarBateria() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        assertEquals("Bateria em bom estado.", sistema.verificarBateria());

        SistemaEletrico sistemaDesc = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", false, "MarcaX");
        assertEquals("Bateria descarregada.", sistemaDesc.verificarBateria());
    }

    @Test
    public void testSubstituirBateriaExecutaSemErro() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        assertTimeout(Duration.ofMillis(100), () -> {
            sistema.substituirBateria();
        });
    }

    @Test
    public void testTestarSistemaExecutaSemErro() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        assertTimeout(Duration.ofMillis(100), () -> {
            sistema.testarSistema();
        });
    }

    @Test
    public void testGettersRetornamValoresEsperados() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");

        assertArrayEquals(sistema.getNomesGetters(),
                new String[]{"getVoltagem", "getCapacidade", "getTipoDeBateria", "isEstado", "getMarca"},
                "Os arrays de getters devem ser iguais");

        List<Object> valoresEsperados = Arrays.asList(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        List<Object> valoresAtuais = Arrays.asList(sistema.getValoresAtributos());

        assertIterableEquals(valoresEsperados, valoresAtuais, "Os valores dos atributos devem ser iguais");
    }

    @Test
    public void testVerificarBateriaComAssertLinesMatch() {
        SistemaEletrico sistemaTrue = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        SistemaEletrico sistemaFalse = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", false, "MarcaX");

        List<String> padraoLinhas = Arrays.asList("Bateria em bom estado\\.", "Bateria descarregada\\.");
        List<String> linhas = Arrays.asList(
                sistemaTrue.verificarBateria(),
                sistemaFalse.verificarBateria()
        );

        assertLinesMatch(padraoLinhas, linhas, "As linhas devem corresponder aos padrões");
    }

    @Test
    public void testAssertNullComObjetoNulo() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        assertNull(sistema.metodoQueRetornaNull(), "O método deve retornar null");
    }

    @Test
    public void testAssertThrowsExcecao() {
        SistemaEletrico sistema = new SistemaEletrico(12.0, 100.0, "Chumbo-ácido", true, "MarcaX");
        Executable executavel = () -> sistema.metodoQueLancaExcecao();
        IllegalStateException excecao = assertThrows(IllegalStateException.class, executavel, "Deve lançar IllegalStateException");
        assertEquals("Erro intencional", excecao.getMessage());
    }
}
