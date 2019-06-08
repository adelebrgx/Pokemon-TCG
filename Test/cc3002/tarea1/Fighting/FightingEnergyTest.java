package cc3002.tarea1.Fighting;

import cc3002.tarea1.Player;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FightingEnergyTest {
    private IEnergy fighting;
    private Player Blue;
    private IPokemon mankey;

    @Before
    public void setUp() {
        fighting= new FightingEnergy();
        Blue=new Player("Blue");
        mankey=new BasicFightingPokemon("Mankey",56,60,new ArrayList<>());

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Fighting",fighting.type());

    }
    @Test
    public void EnergyPlayedTest(){
        Blue.drawCard(mankey);
        Blue.selectPokemon(mankey);
        fighting.beingPlayedBy(Blue);
        assertEquals(1, Blue.getSelectedPokemon().getQuantityofAnEnergy(fighting));

    }
}