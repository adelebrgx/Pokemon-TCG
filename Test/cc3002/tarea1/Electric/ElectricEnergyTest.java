package cc3002.tarea1.Electric;

import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricEnergyTest {
    private IEnergy electric;

    @Before
    public void setUp() throws Exception {
        electric= new ElectricEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Electric",electric.type());

    }
}