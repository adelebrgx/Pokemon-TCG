package cc3002.tarea1.Fire;
import cc3002.tarea1.IPokemon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirePokemonTest {
    private IPokemon charmander;
    @Before
    public void setUp() throws Exception {
        charmander=new FirePokemon("Charmander",7,50);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Charmander";
        int expectedPokedexID=7;
        int expectedHP=50;
        assertEquals(expectedName, charmander.getName());
        assertEquals(expectedPokedexID, charmander.getPokedexID());
        assertEquals(expectedHP,charmander.getHP());
    }
}