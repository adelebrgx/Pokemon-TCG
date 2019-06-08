package cc3002.tarea1.Electric;

import cc3002.tarea1.Player;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ElectricEnergyTest {
    private IEnergy electric;
    private Player Blue;
    private IPokemon pikachu;

    @Before
    public void setUp() {
        electric= new ElectricEnergy();
        Blue=new Player("Blue");
        pikachu=new BasicElectricPokemon("Pikachu",25,90,new ArrayList<>());

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Electric",electric.type());

    }
    @Test
    public void EnergyPlayedTest(){
        Blue.drawCard(pikachu);
        Blue.selectPokemon(pikachu);
        electric.beingPlayedBy(Blue);
        assertEquals(1, Blue.getSelectedPokemon().getQuantityofAnEnergy(electric));

    }
}