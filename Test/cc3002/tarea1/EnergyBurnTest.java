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
import static org.junit.Assert.assertThat;

public class EnergyBurnTest {
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

    private EnergyBurn energyBurn;


    private Player Blue;

    @Before
    public void setUp() {

        charmander= new BasicFirePokemon("Charmander",3,50,new ArrayList<>());
        squirtle= new BasicWaterPokemon("Squirtle", 6, 50, new ArrayList<>());
        pikachu=new BasicElectricPokemon("Pikachu", 9, 50, new ArrayList<>());
        abra=new BasicPsychicPokemon("Abra", 12, 50, new ArrayList<>());
        bulbasaur=new BasicPlantPokemon("Bulbasaur", 15, 50, new ArrayList<>());
        mankey=new BasicFightingPokemon("Mankey", 21, 50, new ArrayList<>());

        energyBurn= new EnergyBurn("Energy Burn", "All the pokemon's energies turn into the pokemon's type");
        Blue=new Player("Blue");
        water= new WaterEnergy();
        plant=new PlantEnergy();
        fighting=new FightingEnergy();
        fire= new FireEnergy();
        electric=new ElectricEnergy();
        psychic=new PsychicEnergy();
    }

    @Test
    public void EnergyBurnCenterTest(){
        assertEquals(true, Blue.getState().isInInitialState());
        assertEquals("Energy Burn",energyBurn.getName());

    }

    @Test
    public void EnergyBurnFirePokemonFunctionnalities(){
        assertEquals(true, Blue.getState().isInInitialState());
        charmander.receiveEnergy(fighting);
        charmander.receiveEnergy(water);
        charmander.receiveEnergy(plant);
        charmander.receiveEnergy(plant);

        Blue.takeCard(charmander);
        Blue.setPlaying(true);
        Blue.playCard(charmander);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn,charmander);

        assertEquals(4, charmander.getQuantityofAnEnergy(fire));


    }

    @Test
    public void EnergyBurnWaterPokemonFunctionnalities(){
        squirtle.receiveEnergy(fighting);
        squirtle.receiveEnergy(fire);
        squirtle.receiveEnergy(plant);
        squirtle.receiveEnergy(plant);

        Blue.takeCard(squirtle);
        Blue.setPlaying(true);
        Blue.playCard(squirtle);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn,squirtle);

        assertEquals(4, squirtle.getQuantityofAnEnergy(water));


    }

    @Test
    public void EnergyBurnPlantPokemonFunctionnalities(){
        bulbasaur.receiveEnergy(fighting);
        bulbasaur.receiveEnergy(fire);
        bulbasaur.receiveEnergy(water);
        bulbasaur.receiveEnergy(water);

        Blue.takeCard( bulbasaur);
        Blue.setPlaying(true);
        Blue.playCard( bulbasaur);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn, bulbasaur);

        assertEquals(4, bulbasaur.getQuantityofAnEnergy(plant));


    }

    @Test
    public void EnergyBurnElectricPokemonFunctionnalities(){
        pikachu.receiveEnergy(fighting);
        pikachu.receiveEnergy(fire);
        pikachu.receiveEnergy(plant);
        pikachu.receiveEnergy(plant);

        Blue.takeCard(pikachu);
        Blue.setPlaying(true);
        Blue.playCard(pikachu);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn,pikachu);

        assertEquals(4, pikachu.getQuantityofAnEnergy(electric));


    }

    @Test
    public void EnergyBurnPsychicPokemonFunctionnalities(){
        abra.receiveEnergy(fighting);
        abra.receiveEnergy(fire);
        abra.receiveEnergy(plant);
        abra.receiveEnergy(plant);

        Blue.takeCard(abra);
        Blue.setPlaying(true);
        Blue.playCard(abra);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn,abra);

        assertEquals(4, abra.getQuantityofAnEnergy(psychic));


    }

    @Test
    public void EnergyBurnFightingPokemonFunctionnalities(){
        mankey.receiveEnergy(fighting);
        mankey.receiveEnergy(fire);
        mankey.receiveEnergy(plant);
        mankey.receiveEnergy(plant);

        Blue.takeCard(mankey);
        Blue.setPlaying(true);
        Blue.playCard(mankey);
        Blue.setState(new FirstState());

        Blue.enableHability(energyBurn,mankey);

        assertEquals(4, mankey.getQuantityofAnEnergy(fighting));


    }





}