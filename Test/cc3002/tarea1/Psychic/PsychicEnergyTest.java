package cc3002.tarea1.Psychic;


import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PsychicEnergyTest {
    private IEnergy psychic;
    private Entrenador Blue;
    private IPokemon abra;

    @Before
    public void setUp() throws Exception {
        psychic= new PsychicEnergy();
        Blue=new Entrenador("Blue");
        abra= abra=new PsychicPokemon("Abra",63,50, new ArrayList<>());
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