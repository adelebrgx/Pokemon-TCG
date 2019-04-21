package cc3002.tarea1.entrenador;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntrenadorTest {

    private Entrenador Sacha;
    private IPokemon charmander;
    private IPokemon squirtle;

    @Before
    public void setUp() throws Exception {
    Sacha= new Entrenador("Sacha");
    charmander=new FirePokemon("Charmander",4,50);
    squirtle= new WaterPokemon("Squirtle", 7, 50);


    }

    @Test
    public void SimpleEntrenadorTest(){
        String expectedName="Sacha";
        assertEquals(expectedName, Sacha.getName());

    }

    public void addPokemontoBankTest(){
        Sacha.addPokemontoBank(charmander);
        Sacha.addPokemontoBank(squirtle);
        String expectedPokemon="Charmander";
        String expectedElement="Charmander";
        String expectedElement2="Squirtle";
        assertEquals(expectedElement2,Sacha.getBank().get(1).getName());
        assertEquals(expectedElement,Sacha.getBank().get(0).getName());
        assertEquals(expectedPokemon, Sacha.getSelectedPokemon().getName());

    }
}