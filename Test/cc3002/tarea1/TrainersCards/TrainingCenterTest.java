package cc3002.tarea1.TrainersCards;

import cc3002.tarea1.*;
import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Plant.BasicPlantPokemon;
import cc3002.tarea1.Plant.Phase1PlantPokemon;
import cc3002.tarea1.Plant.Phase2PlantPokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TrainingCenterTest {
    private IPokemon squirtle;
    private IPokemon watortle;
    private IPokemon blastoise;
    private IPokemon charmander;
    private IPokemon charmeleon;
    private  IPokemon bulbasaur;
    private IPokemon venusaur;
    private IPokemon ivysaur;
    private IPokemon pichu;
    private TrainingCenter training1;
    private TrainingCenter training2;
    private Controller controller;
    private Player Blue;
    private Player Red;

    @Before
    public void setUp() {
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>() );
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        charmeleon= new Phase1FirePokemon( "Charmeleon",4,50,new ArrayList<>());
        pichu=new BasicElectricPokemon("Pichu", 60, 30, new ArrayList<>() );
        bulbasaur=new BasicPlantPokemon("Bulbasaur",1,50,new ArrayList<>());
        ivysaur=new Phase1PlantPokemon("Ivysaur",2,70,new ArrayList<>());
        venusaur=new Phase2PlantPokemon("Venusaur",3, 95, new ArrayList<>());
        training1 = new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 20);
        training2 = new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 30);
        controller=new Controller();

    }

    @Test
    public void BasicTrainingCenterTest(){

        assertEquals("Each Pokemon Phase 1 or 2 receives +x HP", training1.getDescription());
        assertEquals(20, training1.getX());

    }

    @Test
    public void TrainingCenterFunctionnalities() {
        controller.initGame();

        Blue = controller.getFirst();
        Red = controller.getSecond();

        assertEquals(true, Blue.getIsPlaying());
        assertEquals(true, Blue.getState().isInInitialState());

        assertEquals(null, controller.getStateCard());

        Blue.takeCard(squirtle);
        Blue.takeCard(watortle);
        Blue.takeCard(blastoise);
        Blue.takeCard(charmander);
        Blue.takeCard(charmeleon);
        Blue.takeCard(pichu);

        Blue.setState(new FirstState());
        Blue.setPlaying(true);

        Blue.playCard(squirtle);
        Blue.playCard(watortle);
        Blue.playCard(blastoise);
        Blue.playCard(charmander);
        Blue.playCard(charmeleon);
        Blue.playCard(pichu);

        assertEquals(3, Blue.getBank().size());

        Blue.endActions();
        Blue.endTurn();

        assertEquals(Red, controller.getPlaying());


        Red.takeCard(bulbasaur);
        Red.takeCard(ivysaur);
        Red.takeCard(training1);
        Red.setState(new FirstState());
        Red.playCard(bulbasaur);
        Red.playCard(ivysaur);

        assertEquals(1, Red.getBank().size());
        assertEquals(ivysaur, Red.getBank().get(0));


        Red.playCard(training1);

        assertEquals(110, blastoise.getHP());
        assertEquals(70, charmeleon.getHP());
        assertEquals(30, pichu.getHP());
        assertEquals(90, ivysaur.getHP());

        assertEquals(training1, controller.getStateCard());

        Red.endActions();
        Red.endTurn();

        assertEquals(Blue, controller.getPlaying());



        Blue.setState(new FirstState());
        Blue.takeCard(training2);
        Blue.playCard(training2);


        assertEquals(140, blastoise.getHP());
        assertEquals(100, charmeleon.getHP());
        assertEquals(30, pichu.getHP());
        assertEquals(120, ivysaur.getHP());


        assertEquals(training2, controller.getStateCard());



    }







}