package cc3002.tarea1.Psychic;
import cc3002.tarea1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PsychicPokemonTest {
    private IPokemon   abra;
    private IPokemon kadabra;
    private IPokemon alakazam;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack psyshock;
    private Player Blue;
    @Before
    public void setUp() {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        psyshock=new BasicAttack("Psyshock",30,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        abra=new BasicPsychicPokemon("Abra",63,50, new ArrayList<>());
        kadabra=new Phase1PsychicPokemon("Kadabra",64,80, new ArrayList<>(Arrays.asList(shadowbowl)));
        alakazam=new Phase2PsychicPokemon("Alakazam",65,90, new ArrayList<>());
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
    public void hurtAnotherPokemon(){
        kadabra.hurt(abra, shadowbowl);
        assertEquals(0, abra.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){
        Blue.drawCard(abra);
        Blue.drawCard(kadabra);
        abra.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(abra, Blue.getSelectedPokemon());
        kadabra.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(kadabra, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.drawCard(abra);
        Blue.drawCard(kadabra);
        kadabra.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.drawCard(abra);
        Blue.drawCard(kadabra);
        Blue.drawCard(alakazam);
        abra.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(abra, Blue.getSelectedPokemon());
        kadabra.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(kadabra, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());
        alakazam.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(alakazam, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.drawCard(abra);
        Blue.drawCard(kadabra);
        Blue.drawCard(alakazam);
        abra.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(abra, Blue.getSelectedPokemon());
        alakazam.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(abra, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }



}