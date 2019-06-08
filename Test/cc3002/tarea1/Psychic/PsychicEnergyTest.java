package cc3002.tarea1.Psychic;


import cc3002.tarea1.Player;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PsychicEnergyTest {
    private IEnergy psychic;
    private Player Blue;
    private IPokemon abra;

    @Before
    public void setUp() {
        psychic= new PsychicEnergy();
        Blue=new Player("Blue");
        abra=new BasicPsychicPokemon("Abra",63,50, new ArrayList<>());
    }


    @Test
    public void SimplePokemonTest(){
        assertEquals("Psychic",psychic.type());

    }
    @Test
    public void EnergyPlayedTest(){

        Blue.drawCard(abra);
        Blue.selectPokemon(abra);
        psychic.beingPlayedBy(Blue);
        assertEquals(1, Blue.getSelectedPokemon().getQuantityofAnEnergy(psychic));

    }
}