package cc3002.tarea1.Electric;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Fire.FirePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricPokemonTest {
    private IPokemon pikachu;
    @Before
    public void setUp() throws Exception {
        pikachu=new FirePokemon("Pikachu",25,70);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Pikachu";
        int expectedPokedexID=25;
        int expectedHP=70;
        assertEquals(expectedName, pikachu.getName());
        assertEquals(expectedPokedexID, pikachu.getPokedexID());
        assertEquals(expectedHP,pikachu.getHP());
    }
}