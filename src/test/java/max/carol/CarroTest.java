package max.carol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
