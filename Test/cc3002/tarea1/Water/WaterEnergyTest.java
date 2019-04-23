package cc3002.tarea1.Water;

import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterEnergyTest {
    private IEnergy water;

    @Before
    public void setUp() throws Exception {
        water= new WaterEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Water",water.type());

    }
}