package cc3002.tarea1.Water;

import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.IPokemon;

import static org.junit.Assert.*;

public class WaterPokemonTest {
    private IPokemon squirtle;
    @Before
    public void setUp() throws Exception {
        squirtle=new WaterPokemon("Squirtle",7,50);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Squirtle";
        int expectedPokedexID=7;
        int expectedHP=50;
        assertEquals(expectedName, squirtle.getName());
        assertEquals(expectedPokedexID, squirtle.getPokedexID());
        assertEquals(expectedHP,squirtle.getHP());
    }
}