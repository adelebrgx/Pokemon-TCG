package cc3002.tarea1;

import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.Fighting.BasicFightingPokemon;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Plant.BasicPlantPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.BasicPsychicPokemon;
import cc3002.tarea1.Psychic.PsychicEnergy;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ElectricShockTest {
    private IPokemon charmander;
    private IPokemon squirtle;
    private IPokemon pikachu;
    private IPokemon abra;
    private IPokemon bulbasaur;
    private IPokemon mankey;
    private PlantEnergy plant;
    private FightingEnergy fighting;
    private WaterEnergy water;
    private FireEnergy fire;
    private ElectricEnergy electric;
    private PsychicEnergy psychic;

    private ElectricShock electricShock;


    private Player Blue;
    private Player Red;

    @Before
    public void setUp() {

        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        squirtle= new BasicWaterPokemon("Squirtle", 6, 50, new ArrayList<>());
        pikachu=new BasicElectricPokemon("Pikachu", 9, 50, new ArrayList<>());
        abra=new BasicPsychicPokemon("Abra", 12, 50, new ArrayList<>());
        bulbasaur=new BasicPlantPokemon("Bulbasaur", 15, 50, new ArrayList<>());
        mankey=new BasicFightingPokemon("Mankey", 21, 50, new ArrayList<>());

        Blue=new Player("Blue");
        Red=new Player("Red");


        electricShock= new ElectricShock("Electric Shock", 0, "Throw a coin. If it's tails, the opponent's selected Pokemon receives x damage",30);

    }

    @Test
    public void ElectricShockBasicTest(){

        assertEquals("Electric Shock",electricShock.getName());
        assertEquals(30, electricShock.getX());

    }


    @Test
    public void ElectricShockFunctionnalitiesTest(){

        boolean result=false;
        charmander.setAttack(electricShock);
        Blue.setPlaying(true);
      Blue.takeCard(charmander);
      Blue.setState(new FirstState());
      Blue.playCard(charmander);

      Red.takeCard(squirtle);
      Red.setState(new FirstState());
      Red.setPlaying(true);
      Red.playCard(squirtle);

      assertEquals(charmander, Blue.getSelectedPokemon());
      assertEquals(electricShock, Blue.getSelectedPokemon().getAttacksList().get(0));
      assertEquals(squirtle, Red.getSelectedPokemon());


      Blue.setState(new SecondState());
      Blue.useAttack(electricShock,Red);

      if (Blue.getSelectedPokemon().getHP()<=50){
          result=true;
      }

      assertEquals(true, result);


    }


    }