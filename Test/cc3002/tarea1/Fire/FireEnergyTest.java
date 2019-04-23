package cc3002.tarea1.Fire;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FireEnergyTest {
    private IEnergy fire;
    private Entrenador Blue;
    private IPokemon charmander;

    @Before
    public void setUp() throws Exception {
        fire= new FireEnergy();
        Blue= new Entrenador("Blue");
        charmander=new FirePokemon("Charmander",4,50,new ArrayList<>());

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Fire",fire.type());

    }
    @Test
    public void EnergyPlayedTest(){
        Blue.drawCard(charmander);
        Blue.selectPokemon(charmander);
        fire.beingPlayedBy(Blue);
        assertEquals(1, Blue.getSelectedPokemon().getQuantityofAnEnergy(fire));

    }
}