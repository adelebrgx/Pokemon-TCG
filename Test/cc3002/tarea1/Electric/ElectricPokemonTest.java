package cc3002.tarea1.Electric;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ElectricPokemonTest {
    private IPokemon pikachu;
    private IPokemon raichu;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack discharge;
    private Entrenador Blue;
    @Before
    public void setUp() throws Exception {
        shadowbowl=new Attack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new Attack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new Attack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new Attack("Thundershock",35,"Attack of pokemon type: electric");
        discharge=new Attack("Discharge",50,"Attack of pokemon type: electric");
        karatechop=new Attack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new Attack("Aqua Jet",30,"Attack of pokemon type: water");
        pikachu=new ElectricPokemon("Pikachu",25,90,new ArrayList<>());
        raichu=new ElectricPokemon("Raichu", 26, 110, new ArrayList<>(Arrays.asList(discharge)));
        Blue=new Entrenador("Blue");
    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Pikachu", pikachu.getName());
        assertEquals(25, pikachu.getPokedexID());
        assertEquals(90,pikachu.getHP());
    }
    @Test
    public void selectAttackTest(){

        assertEquals("Discharge", raichu.getAttacksList().get(0).getName());
        raichu.setAttack(thundershock);
        pikachu.setAttack(thundershock);
        assertEquals("Thundershock", raichu.getAttacksList().get(1).getName());
        assertEquals("Thundershock", pikachu.getAttacksList().get(0).getName());
        assertEquals(2, raichu.getAttacksList().size());
        assertEquals(1, pikachu.getAttacksList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveWaterAttack(aquajet);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFireAttack(flamethrower);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveElectricAttack(thundershock);
        assertEquals(55, pikachu.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFightingAttack(karatechop);
        assertEquals(30, pikachu.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePlantAttack(tackle);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePsychicAttack(shadowbowl);
        assertEquals(50, pikachu.getHP());
    }

    @Test
    public void PokemonPlayedTest(){
        Blue.drawCard(pikachu);
        Blue.drawCard(pikachu);
        pikachu.beingPlayedBy(Blue);
        pikachu.beingPlayedBy(Blue);
        assertEquals("Pikachu", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
}