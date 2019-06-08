package cc3002.tarea1.Fire;
import cc3002.tarea1.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FirePokemonTest {
    private IPokemon charmander;
    private IPokemon charmeleon;
    private IPokemon charizard;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack firepunch;
    private Player Blue;


    @Before
    public void setUp() {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        firepunch=new BasicAttack("Fire Punch",40,"Attack of pokemon type: fire");
        charmander=new BasicFirePokemon("Charmander",4,50,new ArrayList<>());
        charmeleon=new Phase1FirePokemon("Charmeleon",5,70,new ArrayList<>(Arrays.asList(flamethrower)));
        charizard=new Phase2FirePokemon("Charizard", 6, 90, new ArrayList<>());
        Blue=new Player("Blue");

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Charmander", charmander.getName());
        assertEquals(4, charmander.getPokedexID());
        assertEquals(50,charmander.getHP());
        assertEquals("Fire", charmander.type());
    }

    @Test
    public void selectAttackTest(){

        assertEquals("Flame Thrower", charmeleon.getAttacksList().get(0).getName());
        charmeleon.setAttack(firepunch);
        charmander.setAttack(firepunch);
        assertEquals("Fire Punch", charmeleon.getAttacksList().get(1).getName());
        assertEquals("Fire Punch", charmander.getAttacksList().get(0).getName());
        assertEquals(2, charmeleon.getAttacksList().size());
        assertEquals(1, charmander.getAttacksList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveWaterAttack(aquajet);
        assertEquals(0, charmander.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveFireAttack(flamethrower);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveElectricAttack(thundershock);
        assertEquals(15, charmander.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveFightingAttack(karatechop);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receivePlantAttack(tackle);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receivePsychicAttack(shadowbowl);
        assertEquals(10, charmander.getHP());
    }


    @Test
    public void hurtAnotherPokemon(){
        charmeleon.hurt(charmander, flamethrower);
        assertEquals(20, charmander.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){
        Blue.drawCard(charmander);
        Blue.drawCard(charmeleon);
        charmander.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charmeleon.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmeleon, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.drawCard(charmander);
        Blue.drawCard(charmeleon);
        charmeleon.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.drawCard(charmander);
        Blue.drawCard(charmeleon);
        Blue.drawCard(charizard);
        charmander.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charmeleon.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmeleon, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());
        charizard.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charizard, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.drawCard(charmander);
        Blue.drawCard(charmeleon);
        Blue.drawCard(charizard);
        charmander.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charizard.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }


}