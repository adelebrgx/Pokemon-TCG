package cc3002.tarea1.Water;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WaterEnergyTest {
    private IEnergy water;
    private Entrenador Blue;
    private IPokemon squirtle;

    @Before
    public void setUp() throws Exception {
        water= new WaterEnergy();
        Blue=new Entrenador("Blue");
        squirtle=new WaterPokemon("Squirtle",7,70,new ArrayList<>());
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Water",water.type());

    }

    @Test
    public void EnergyPlayedTest(){
        Blue.drawCard(squirtle);
        Blue.selectPokemon(squirtle);
        water.beingPlayedBy(Blue);
        assertEquals(1, Blue.getSelectedPokemon().getQuantityofAnEnergy(water));

    }
}