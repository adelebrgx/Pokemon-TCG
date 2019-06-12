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
    private IPokemon blastoise;
    private Attack bubble;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Player Blue;
    private TrainingCenter trainingCenter;

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
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        Blue=new Player("Blue");
        trainingCenter= new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 20);
    }

    @Test
    public void BasicPokemonTest(){

        assertEquals("Squirtle", squirtle.getName());
        assertEquals(7, squirtle.getPokedexID());
        assertEquals(70,squirtle.getHP());
        assertEquals(new ArrayList<>(), squirtle.getAbilitiesList());
        assertEquals("Water", squirtle.type());
    }




    @Test
    public void selectAttackTest(){

        assertEquals("Bubble", watortle.getAbilitiesList().get(0).getName());
        watortle.setAbility(aquajet);
        squirtle.setAbility(aquajet);
        assertEquals("Aqua Jet", watortle.getAbilitiesList().get(1).getName());
        assertEquals("Aqua Jet", squirtle.getAbilitiesList().get(0).getName());
        assertEquals(2, watortle.getAbilitiesList().size());
        assertEquals(1, squirtle.getAbilitiesList().size());

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
    public void hurtAnotherPokemon(){
        watortle.hurt(squirtle, bubble);
        assertEquals(30, squirtle.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){
        Blue.takeCard(squirtle);
        Blue.takeCard(watortle);
        squirtle.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(squirtle, Blue.getSelectedPokemon());
        watortle.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(watortle, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.takeCard(squirtle);
        Blue.takeCard(watortle);
        watortle.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.takeCard(squirtle);
        Blue.takeCard(watortle);
        Blue.takeCard(blastoise);
        squirtle.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(squirtle, Blue.getSelectedPokemon());
        watortle.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(watortle, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());
        blastoise.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(blastoise, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.takeCard(squirtle);
        Blue.takeCard(watortle);
        Blue.takeCard(blastoise);
        squirtle.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(squirtle, Blue.getSelectedPokemon());
        blastoise.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(squirtle, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }


    @Test
    public void InspectionTest(){
        squirtle.isBeingInspected(trainingCenter);
        watortle.isBeingInspected(trainingCenter);
        blastoise.isBeingInspected(trainingCenter);
        assertEquals(70,squirtle.getHP());
        assertEquals(105,watortle.getHP());
        assertEquals(110,blastoise.getHP());
    }


}