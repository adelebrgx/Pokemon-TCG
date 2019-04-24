package cc3002.tarea1.Psychic;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Player;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PsychicPokemonTest {
    private IPokemon   abra;
    private IPokemon kadabra;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack psyshock;
    private Player Blue;
    @Before
    public void setUp() throws Exception {
        shadowbowl=new Attack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        psyshock=new Attack("Psyshock",30,"Attack of pokemon type: psychic");
        tackle=new Attack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new Attack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new Attack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new Attack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new Attack("Aqua Jet",30,"Attack of pokemon type: water");
        abra=new PsychicPokemon("Abra",63,50, new ArrayList<>());
        kadabra=new PsychicPokemon("Kadabra",64,80, new ArrayList<>(Arrays.asList(shadowbowl)));
        Blue=new Player("Blue");

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Abra", abra.getName());
        assertEquals(63, abra.getPokedexID());
        assertEquals(50,abra.getHP());
        assertEquals("Psychic", abra.type());
    }
    @Test
    public void selectAttackTest(){

        assertEquals("Shadow Bowl", kadabra.getAttacksList().get(0).getName());
        kadabra.setAttack(psyshock);
        abra.setAttack(psyshock);
        assertEquals("Psyshock", kadabra.getAttacksList().get(1).getName());
        assertEquals("Psyshock", abra.getAttacksList().get(0).getName());
        assertEquals(2, kadabra.getAttacksList().size());
        assertEquals(1, abra.getAttacksList().size());

    }
    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receiveWaterAttack(aquajet);
        assertEquals(20, abra.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receiveFireAttack(flamethrower);
        assertEquals(20, abra.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receiveElectricAttack(thundershock);
        assertEquals(15, abra.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receiveFightingAttack(karatechop);
        assertEquals(50, abra.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receivePlantAttack(tackle);
        assertEquals(20, abra.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(50, abra.getHP());
        abra.receivePsychicAttack(shadowbowl);
        assertEquals(0, abra.getHP());
    }

    @Test
    public void PokemonPlayedTest(){
        Blue.drawCard(abra);
        Blue.drawCard(abra);
        abra.beingPlayedBy(Blue);
        abra.beingPlayedBy(Blue);
        assertEquals("Abra", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
}