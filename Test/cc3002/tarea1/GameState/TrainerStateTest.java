package cc3002.tarea1.GameState;

import cc3002.tarea1.*;
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
import java.util.List;

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
    private EnergyBurn energyBurn;

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
        bubble = new BasicAttack("Bubble", 10,"Attack of pokemon type: water");
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        abra=new BasicPsychicPokemon("Abra",63,50, new ArrayList<>());
        energyBurn= new EnergyBurn("","");

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

        Blue.takeCard(charmander);
        Blue.selectPokemon(charmander);

        squirtle.setAbility(bubble);
        Red.takeCard(squirtle);
        Red.selectPokemon(squirtle);



        Red.initiateDeck(list);
        Red.setPlaying(true);
        Red.setState(new InitialState());
        assertEquals(true, Red.getIsPlaying());
        assertEquals(true, Red.getState().isInInitialState());

        Red.endActions();
        assertEquals(true, Red.getState().isInInitialState());

        Red.endTurn();
        assertEquals(true, Red.getState().isInInitialState());

        squirtle.setAbility(energyBurn);
        Red.enableHability(energyBurn);
        assertEquals(true, Red.getState().isInInitialState());

        List<IPokemon> list= Red.seeMyPokemons();
        assertEquals(0, list.size());

        List<IPokemon> list2= Red.seeOpponentPokemons(Blue);
        assertEquals(0, list.size());

        List<ICard> list3=Red.seeCards();
        assertEquals(0, list.size());

        Red.useAttack(bubble,Blue);
        assertEquals(true,Red.getState().isInInitialState());

        Red.drawCard();
        assertEquals(true, Red.getIsPlaying());
        assertEquals(true, Red.getState().isInFirstState());



        Red.playCard(squirtle);
        assertEquals(true, Red.getState().isInFirstState());



        List<IPokemon> list4= Red.seeMyPokemons();
        assertEquals(1, list4.size());

        List<IPokemon> list5= Red.seeOpponentPokemons(Blue);
        assertEquals(1, list5.size());

        List<ICard> list6=Red.seeCards();
        assertEquals(1, list6.size());

        Red.useAttack(bubble, Blue);
        assertEquals(true, Red.getState().isInFirstState());

        Red.endTurn();
        assertEquals(true, Red.getState().isInFirstState());
        Red.enableHability(energyBurn);
        assertEquals(true, Red.getState().isInFirstState());

        Red.endActions();
        assertEquals(true, Red.getState().isInSecondState());

        List<IPokemon> list7= Red.seeMyPokemons();
        assertEquals(0, list7.size());

        List<IPokemon> list8= Red.seeOpponentPokemons(Blue);
        assertEquals(0, list8.size());

        List<ICard> list9=Red.seeCards();
        assertEquals(0, list9.size());

        Red.drawCard();
        assertEquals(true, Red.getState().isInSecondState());

        Red.playCard(squirtle);
        assertEquals(true, Red.getState().isInSecondState());

        Red.enableHability(energyBurn);
        assertEquals(true, Red.getState().isInSecondState());

        Red.useAttack(bubble, Blue);
        assertEquals(true, Red.getState().isInInitialState());








    }





}