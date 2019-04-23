package cc3002.tarea1.Psychic;


import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PsychicEnergyTest {
    private IEnergy psychic;

    @Before
    public void setUp() throws Exception {
        psychic= new PsychicEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Psychic",psychic.type());

    }
}