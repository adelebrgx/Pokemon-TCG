package cc3002.tarea1.Fighting;

import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FightingEnergyTest {
    private IEnergy fighting;

    @Before
    public void setUp() throws Exception {
        fighting= new FightingEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Fighting",fighting.type());

    }
}