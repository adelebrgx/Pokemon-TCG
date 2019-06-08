package cc3002.tarea1.Plant;
import cc3002.tarea1.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PlantPokemonTest {
    private IPokemon bulbasaur;
    private IPokemon ivysaur;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack vinewhip;
    private Player Blue;
    @Before
    public void setUp() {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of type pokemon: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of type pokemon: plant");
        vinewhip=new BasicAttack("Vine Whip",35,"Attack of type pokemon: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of type pokemon: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of type pokemon: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of type pokemon: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of type pokemon: water");
        bulbasaur=new BasicPlantPokemon("Bulbasaur",1,50,new ArrayList<>());
        ivysaur=new Phase1PlantPokemon("Ivysaur",2,70,new ArrayList<>(Arrays.asList(tackle)));
        Blue=new Player("Blue");
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals(1, bulbasaur.getPokedexID());
        assertEquals(50,bulbasaur.getHP());
        assertEquals("Plant", bulbasaur.type());
    }

    @Test
    public void selectAttackTest(){

        assertEquals("Tackle", ivysaur.getAttacksList().get(0).getName());
        bulbasaur.setAttack(vinewhip);
        ivysaur.setAttack(vinewhip);
        assertEquals("Vine Whip", ivysaur.getAttacksList().get(1).getName());
        assertEquals("Vine Whip", bulbasaur.getAttacksList().get(0).getName());
        assertEquals(2, ivysaur.getAttacksList().size());
        assertEquals(1, bulbasaur.getAttacksList().size());

    }
    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receiveWaterAttack(aquajet);
        assertEquals(50, bulbasaur.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receiveFireAttack(flamethrower);
        assertEquals(0, bulbasaur.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receiveElectricAttack(thundershock);
        assertEquals(15, bulbasaur.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receiveFightingAttack(karatechop);
        assertEquals(20, bulbasaur.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receivePlantAttack(tackle);
        assertEquals(20, bulbasaur.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(50, bulbasaur.getHP());
        bulbasaur.receivePsychicAttack(shadowbowl);
        assertEquals(10, bulbasaur.getHP());
    }
    @Test
    public void PokemonPlayedTest(){
        Blue.drawCard(bulbasaur);
        Blue.drawCard(bulbasaur);
        bulbasaur.beingPlayedBy(Blue);
        bulbasaur.beingPlayedBy(Blue);
        assertEquals("Bulbasaur", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
    @Test
    public void hurtAnotherPokemon(){
        ivysaur.hurt(bulbasaur, tackle);
        assertEquals(20, bulbasaur.getHP());
    }
}