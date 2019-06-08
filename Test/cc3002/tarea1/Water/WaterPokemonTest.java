package cc3002.tarea1.Water;

import cc3002.tarea1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WaterPokemonTest {
    private IPokemon squirtle;
    private IPokemon watortle;
    private Attack bubble;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Player Blue;

    @Before
    public void setUp() {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet", 30, "Attack of pokemon type: water");
        bubble = new BasicAttack("Bubble", 40,"Attack of pokemon type: water");
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>(Arrays.asList(bubble)) );
        Blue=new Player("Blue");
    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Squirtle", squirtle.getName());
        assertEquals(7, squirtle.getPokedexID());
        assertEquals(70,squirtle.getHP());
        assertEquals(new ArrayList<>(), squirtle.getAttacksList());
        assertEquals("Water", squirtle.type());
    }
    @Test
    public void selectAttackTest(){

        assertEquals("Bubble", watortle.getAttacksList().get(0).getName());
        watortle.setAttack(aquajet);
        squirtle.setAttack(aquajet);
        assertEquals("Aqua Jet", watortle.getAttacksList().get(1).getName());
        assertEquals("Aqua Jet", squirtle.getAttacksList().get(0).getName());
        assertEquals(2, watortle.getAttacksList().size());
        assertEquals(1, squirtle.getAttacksList().size());

    }
    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receiveWaterAttack(aquajet);
        assertEquals(40, squirtle.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receiveFireAttack(flamethrower);
        assertEquals(40, squirtle.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receiveElectricAttack(thundershock);
        assertEquals(0, squirtle.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receiveFightingAttack(karatechop);
        assertEquals(70, squirtle.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receivePlantAttack(tackle);
        assertEquals(10, squirtle.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(70, squirtle.getHP());
        squirtle.receivePsychicAttack(shadowbowl);
        assertEquals(30, squirtle.getHP());
    }
    @Test
    public void PokemonPlayedTest(){
        Blue.drawCard(squirtle);
        Blue.drawCard(squirtle);
        squirtle.beingPlayedBy(Blue);
        squirtle.beingPlayedBy(Blue);
        assertEquals("Squirtle", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
    @Test
    public void hurtAnotherPokemon(){
        watortle.hurt(squirtle, bubble);
        assertEquals(30, squirtle.getHP());
    }


}