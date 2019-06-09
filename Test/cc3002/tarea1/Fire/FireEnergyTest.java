package cc3002.tarea1.Fire;

import cc3002.tarea1.Player;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FireEnergyTest {
    private IEnergy fire;
    private Player Blue;
    private IPokemon charmander;

    @Before
    public void setUp() {
        fire= new FireEnergy();
        Blue= new Player("Blue");
        charmander=new BasicFirePokemon("Charmander",4,50,new ArrayList<>());

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Fire",fire.type());

    }

}