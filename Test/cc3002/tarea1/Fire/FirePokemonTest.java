package cc3002.tarea1.Fire;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Player;
import cc3002.tarea1.IPokemon;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FirePokemonTest {
    private IPokemon charmander;
    private IPokemon charmeleon;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack firepunch;
    private Player Blue;
    @Before
    public void setUp() throws Exception {
        shadowbowl=new Attack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new Attack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new Attack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new Attack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new Attack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new Attack("Aqua Jet",30,"Attack of pokemon type: water");
        firepunch=new Attack("Fire Punch",40,"Attack of pokemon type: fire");
        charmander=new FirePokemon("Charmander",4,50,new ArrayList<>());
        charmeleon=new FirePokemon("Charmeleon",5,70,new ArrayList<>(Arrays.asList(flamethrower)));
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
    public void PokemonPlayedTest(){
        Blue.drawCard(charmander);
        Blue.drawCard(charmander);
        charmander.beingPlayedBy(Blue);
        charmander.beingPlayedBy(Blue);
        assertEquals("Charmander", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
}