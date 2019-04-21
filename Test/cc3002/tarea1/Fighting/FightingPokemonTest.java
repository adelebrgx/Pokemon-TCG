package cc3002.tarea1.Fighting;
import cc3002.tarea1.IPokemon;

import cc3002.tarea1.Fire.FirePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FightingPokemonTest {
    private IPokemon mankey;
    @Before
    public void setUp() throws Exception {
        mankey=new FirePokemon("Mankey",56,60);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Mankey";
        int expectedPokedexID=56;
        int expectedHP=60;
        assertEquals(expectedName, mankey.getName());
        assertEquals(expectedPokedexID, mankey.getPokedexID());
        assertEquals(expectedHP,mankey.getHP());
    }
}