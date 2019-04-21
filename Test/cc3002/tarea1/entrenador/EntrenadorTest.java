package cc3002.tarea1.entrenador;

import cc3002.tarea1.Entrenador;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntrenadorTest {

    private Entrenador Sacha;

    @Before
    public void setUp() throws Exception {
    Sacha= new Entrenador("Sacha");
    }

    @Test
    public void SimpleNameTest(){
        String expected="Sacha";
        assertEquals("Sacha", Sacha.getName());
    }
}