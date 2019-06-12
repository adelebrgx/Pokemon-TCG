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

public class SuperScoopUpTest {
    private IBasicPokemon squirtle;
    private IPhase1Pokemon watortle;
    private IPhase2Pokemon blastoise;
    private IPokemon charmander;
    private IPokemon charmeleon;
    private IPokemon pichu;

    private SuperScoopUp superScoopUp;
    private BasicObjectCard basic;
    private BasicObjectCard basic2;


    private Player Blue;

    @Before
    public void setUp() {
        squirtle=new BasicWaterPokemon("Squirtle",7,70,new ArrayList<>());
        watortle=new Phase1WaterPokemon("Watortle", 8, 85, new ArrayList<>() );
        blastoise=new Phase2WaterPokemon("Blastoise",9,90,new ArrayList<>());
        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        charmeleon= new Phase1FirePokemon( "Charmeleon",4,50,new ArrayList<>());
        pichu=new BasicElectricPokemon("Pichu", 60, 30, new ArrayList<>() );
        superScoopUp=new SuperScoopUp("SuperScoopUp", "Throw a coin. If the result's heads, get one Pokemon in your Bank and all the cards associated back to yourd hand");
        Blue=new Player("Blue");
        basic=new BasicObjectCard("Basic Card", "Basic Card which will testify the functionnalites of a normal object works");
        basic2=new BasicObjectCard("Basic Card", "Basic Card which will testify the functionnalites of a normal object works");
    }

    @Test
    public void BasicSuperScoopUpTest(){

        assertEquals("Throw a coin. If the result's heads, get one Pokemon in your Bank and all the cards associated back to yourd hand", superScoopUp.getDescription());
    }

    @Test
    public void SuperScoopUpFunctionnalitiesTest(){

        squirtle.associateObjectCard(basic);
        Blue.takeCard(superScoopUp);
        Blue.takeCard(squirtle);
        Blue.takeCard(charmander);

        Blue.setState(new FirstState());

        Blue.setPlaying(true);
        Blue.playCard(squirtle);
        Blue.playCard(charmander);

        assertEquals(2, Blue.getBank().size());
        assertEquals(1, Blue.getHand().size());

        Blue.playCard(superScoopUp);

        boolean result=false;

        if(Blue.getBank().size()==2 || Blue.getBank().size()==1){
            result=true;
        }

        assertEquals(true, result);
    }

    @Test
    public void SuperScoopUpVsObjectCardSimple(){
        squirtle.associateObjectCard(basic);
        assertEquals(basic, squirtle.getObjectCardAssociated());

        Blue.takeCard(squirtle);
        Blue.takeCard(basic2);

        Blue.setState(new FirstState());

        Blue.setPlaying(true);
        Blue.playCard(squirtle);

        Blue.playCard(basic2);
        assertEquals(basic2, squirtle.getObjectCardAssociated());

        basic.inspectBasicPokemon(squirtle);
        basic.inspectPhase1Pokemon(watortle);
        basic.inspectPhase2Pokemon(blastoise);

        assertEquals(squirtle, Blue.getSelectedPokemon());
        assertEquals(70, squirtle.getHP());
        assertEquals(85, watortle.getHP());
        assertEquals(90, blastoise.getHP());



    }








}