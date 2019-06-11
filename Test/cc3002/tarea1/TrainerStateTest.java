package cc3002.tarea1;

import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Psychic.BasicPsychicPokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TrainerStateTest {
    private Player Blue;
    private Player Red;
    private ArrayList list;
    private FireEnergy fire;
    private WaterEnergy water;
    private IPokemon squirtle;
    private BasicAttack bubble;
    private IPokemon charmander;
    private IPokemon abra;

    @Before
    public void setUp() {

        Blue=new Player("Blue");
        Red=new Player("Red");

        list=new ArrayList();
        fire=new FireEnergy();
        water= new WaterEnergy();
        list.add(fire);
        list.add(water);
        charmander=new BasicFirePokemon("Charmander",4,50,new ArrayList<>());
        bubble = new BasicAttack("Bubble", 100,"Attack of pokemon type: water");
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        abra=new BasicPsychicPokemon("Abra",63,50, new ArrayList<>());

    }

    @Test
    public void BasicTrainerStateTest(){
        assertEquals(true, Blue.getState().isInInitialState());
    }

    @Test
    public void drawCardTest(){
        Blue.initiateDeck(list);
        Blue.setPlaying(true);
        Blue.drawCard();
        assertEquals(true,Blue.getState().isInFirstState());
    }

    @Test
    public void EndActionsTest(){
        Blue.initiateDeck(list);
        Blue.setPlaying(true);
        Blue.drawCard();
        assertEquals(true,Blue.getState().isInFirstState());
        Blue.endActions();
        assertEquals(true,Blue.getState().isInSecondState());
    }

    @Test
    public void EndTurnTest(){
        Blue.initiateDeck(list);
        Blue.setPlaying(true);
        Blue.drawCard();
        assertEquals(true,Blue.getState().isInFirstState());
        Blue.endActions();
        assertEquals(true,Blue.getState().isInSecondState());
        Blue.endTurn();
        assertEquals(true,Blue.getState().isInInitialState());

    }

    @Test
    public void AttackTest(){


        Red.initiateDeck(list);
        Red.setPlaying(true);
        Red.drawCard();

        Red.takeCard(charmander);
        Red.takeCard(abra);

        Red.playCard(charmander);
        Red.playCard(abra);
        Red.endActions();
        Red.endTurn();



        squirtle.setAttack(bubble);

        Blue.setPlaying(true);

        Blue.initiateDeck(list);
        Blue.drawCard();


        Blue.takeCard(squirtle);
        Blue.playCard(squirtle);

        Blue.endActions();

        Blue.useAttack(bubble,Red);
        assertEquals(true, Blue.getState().isInInitialState());
        assertEquals(false, Blue.getState().isInSecondState());


    }





}