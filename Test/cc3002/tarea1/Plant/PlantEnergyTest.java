package cc3002.tarea1.Plant;


import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlantEnergyTest {
    private IEnergy plant;

    @Before
    public void setUp() throws Exception {
        plant= new PlantEnergy();
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Plant", plant.type());

    }
}