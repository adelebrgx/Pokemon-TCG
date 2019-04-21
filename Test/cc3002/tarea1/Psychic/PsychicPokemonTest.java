package cc3002.tarea1.Psychic;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Psychic.PsychicPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PsychicPokemonTest {
    private IPokemon   abra;
    @Before
    public void setUp() throws Exception {
        abra=new PsychicPokemon("Abra",63,50);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Abra";
        int expectedPokedexID=63;
        int expectedHP=50;
        assertEquals(expectedName, abra.getName());
        assertEquals(expectedPokedexID, abra.getPokedexID());
        assertEquals(expectedHP,abra.getHP());
    }
}