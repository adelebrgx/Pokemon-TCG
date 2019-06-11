package cc3002.tarea1;

import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    private IPokemon squirtle;
    private IPokemon watortle;
    private IPokemon blastoise;
    private IPokemon charmander;
    private IPokemon charmeleon;
    private IPokemon pichu;
    private ArrayList list;
    private FireEnergy fire;
    WaterEnergy water;

    private Controller controller;
    private NullController nullC;





    @Before
    public void setUp() {
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>() );
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        charmeleon= new Phase1FirePokemon( "Charmeleon",4,50,new ArrayList<>());
        pichu=new BasicElectricPokemon("Pichu", 60, 30, new ArrayList<>() );
        fire=new FireEnergy();
        water= new WaterEnergy();
        controller=new Controller();
        nullC=new  NullController();
        list=new ArrayList();
        list.add(fire);
        list.add(water);


    }

    @Test
    public void BasicControllerCenterTest(){

        controller.initGame();
        assertEquals("First", controller.getFirst().getName());
        assertEquals("Second", controller.getSecond().getName());
    }

    @Test
    public void NullPatternTest(){
        nullC.initGame();
        assertEquals("First",nullC.getPlaying().getName());
        nullC.SwitchTurns(nullC.getSecond());
        assertEquals("First",nullC.getPlaying().getName());
    }

    @Test
    public void ControllerFunctionnalitiesTest(){
        controller.initGame();
        assertEquals("First", controller.getPlaying().getName());

        Player blue= controller.getFirst();
        Player red= controller.getSecond();

        assertEquals(true, blue.getIsPlaying());
        assertEquals(false, red.getIsPlaying());

        blue.initiateDeck(list);
        red.initiateDeck(list);

        blue.drawCard();
        red.drawCard();
        assertEquals(1,blue.getHand().size());
        assertEquals(0, red.getHand().size());

    }

}