package max.carol;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MotorTest {

    Motor motor = new Motor("combustão", 150, 2.0, "Honda", false);

    @Test
    public void testLigar() {
        motor.ligar();
        assertTrue(motor.isEstado());
    }

    @Test
    public void testDesligar() {
        motor.desligar();
        assertFalse(motor.isEstado());
    }

    @Test
    public void testVerificarEstado() {
        motor.desligar();
        assertEquals("Motor desligado.", motor.verificarEstado());
        motor.ligar();
        assertEquals("Motor em bom estado.", motor.verificarEstado());
    }

    @Test
    public void testAssertArrayEquals() {
        String[] esperado = {"temperatura", "pressão", "rotação"};
        assertArrayEquals(esperado, motor.getSensoresConectados());
    }

    @Test
    public void testAssertIterableEquals() {
        List<String> esperado = List.of("V8", "V6", "1.0 TSI");
        assertIterableEquals(esperado, motor.getModelosDisponiveis());
    }

    @Test
    public void testAssertLinesMatch() {
        List<String> esperado = List.of(
                "1. Ligue o motor",
                "2. Aqueça por 1 minuto",
                "3. Mantenha revisões em dia"
        );
        List<String> atual = List.of(motor.getManualDeUso().split("\n"));
        assertLinesMatch(esperado, atual);
    }

    @Test
    public void testAssertNull() {
        assertNull(motor.getMotorReserva());
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalStateException.class, () -> {
            motor.falhaGrave();
        });
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            motor.operacaoLenta();
        });
    }
}
