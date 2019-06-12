package cc3002.tarea1.TrainersCards;

import cc3002.tarea1.*;
import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.Phase1FirePokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.Phase1WaterPokemon;
import cc3002.tarea1.Water.Phase2WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProfessorCozmosDiscoveryTest {
    private IPokemon squirtle;
    private IPokemon watortle;
    private IPokemon blastoise;
    private IPokemon charmander;
    private IPokemon charmeleon;
    private IPokemon pichu;
    private ProfessorCozmosDiscovery professorCozmosDiscovery;


    private Player Blue;

    @Before
    public void setUp() {
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>() );
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        charmeleon= new Phase1FirePokemon( "Charmeleon",4,50,new ArrayList<>());
        pichu=new BasicElectricPokemon("Pichu", 60, 30, new ArrayList<>() );
        professorCozmosDiscovery=new ProfessorCozmosDiscovery("Professor Cozmos Discovery", "Throw a coin. If the result's tails draw 2 cards, otherwise draw three.");
        Blue=new Player("Blue");
    }

    @Test
    public void BasicProfessorTest(){

        assertEquals("Professor Cozmos Discovery",professorCozmosDiscovery.getTitle());
        assertEquals("Throw a coin. If the result's tails draw 2 cards, otherwise draw three.", professorCozmosDiscovery.getDescription());
    }

    @Test
    public void ProfessorFunctionnalitiesTest(){
        Blue.takeCard(professorCozmosDiscovery);
        Blue.takeCard(squirtle);
        Blue.takeCard(charmander);

        ArrayList<ICard> list= new ArrayList<>();
        list.add(pichu);
        list.add(charmeleon);
        Blue.initiateDeck(list);

        assertEquals(60, Blue.getStack().size());
        assertEquals(3, Blue.getHand().size());

        Blue.setState(new FirstState());
        Blue.setPlaying(true);
        Blue.playCard(professorCozmosDiscovery);

        boolean result=false;

        if(Blue.getHand().size()==5 || Blue.getHand().size()==4){
            result=true;
        }

        assertEquals(true, result);
    }




}