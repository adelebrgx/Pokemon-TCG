package cc3002.tarea1;

import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import javafx.scene.effect.Blend;
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
    private IPokemon pichu;
    private TrainingCenter training;


    private Player Blue;

    @Before
    public void setUp() {
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>() );
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        charmeleon= new Phase1FirePokemon( "Charmeleon",4,50,new ArrayList<>());
        pichu=new BasicElectricPokemon("Pichu", 60, 30, new ArrayList<>() );
        training= new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 20);
        Blue=new Player("Blue");
    }

    @Test
    public void BasicTrainingCenterTest(){

        assertEquals("Each Pokemon Phase 1 or 2 receives +x HP", training.getDescription());
        assertEquals(20,training.getX());

    }

    @Test
    public void TrainingCenterFunctionnalities(){
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

        Blue.takeCard(training);
        Blue.playCard(training);

        assertEquals(110, blastoise.getHP());
        assertEquals(70, charmeleon.getHP());
        assertEquals(30, pichu.getHP());

    }





}