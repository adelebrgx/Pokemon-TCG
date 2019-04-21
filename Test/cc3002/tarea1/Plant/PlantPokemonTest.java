package cc3002.tarea1.Plant;
import cc3002.tarea1.IPokemon;

import cc3002.tarea1.Plant.PlantPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlantPokemonTest {
    private IPokemon bulbasaur;
    @Before
    public void setUp() throws Exception {
        bulbasaur=new PlantPokemon("Bulbasaur",1,50);
    }

    @Test
    public void SimplePokemonTest(){
        String expectedName="Bulbasaur";
        int expectedPokedexID=1;
        int expectedHP=50;
        assertEquals(expectedName, bulbasaur.getName());
        assertEquals(expectedPokedexID, bulbasaur.getPokedexID());
        assertEquals(expectedHP,bulbasaur.getHP());
    }
}