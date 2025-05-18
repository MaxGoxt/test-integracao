package max.carol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarroTest {

    @Test
    void testSoma() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void testErro() {
        assertEquals(8, 2 + 2);
    }
    
    @Test
    void testExemplo() {
        System.out.println("Rodando teste...");
    }
}
