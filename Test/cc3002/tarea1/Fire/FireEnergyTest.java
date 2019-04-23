package cc3002.tarea1.Fire;

import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireEnergyTest {
    private IEnergy fire;

    @Before
    public void setUp() throws Exception {
        fire= new FireEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Fire",fire.type());

    }
}