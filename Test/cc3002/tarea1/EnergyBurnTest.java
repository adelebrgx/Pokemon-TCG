package cc3002.tarea1;

import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.Electric.IElectricPokemon;
import cc3002.tarea1.Fighting.BasicFightingPokemon;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fighting.IFightingPokemon;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.IFirePokemon;
import cc3002.tarea1.Plant.BasicPlantPokemon;
import cc3002.tarea1.Plant.IPlantPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.BasicPsychicPokemon;
import cc3002.tarea1.Psychic.IPsychicPokemon;
import cc3002.tarea1.Psychic.PsychicEnergy;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.IWaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EnergyBurnTest {
    private IFirePokemon charmander;
    private IWaterPokemon squirtle;
    private IElectricPokemon pikachu;
    private IPsychicPokemon abra;
    private IPlantPokemon bulbasaur;
    private IFightingPokemon mankey;
    private PlantEnergy plant;
    private FightingEnergy fighting;
    private WaterEnergy water;
    private FireEnergy fire;
    private ElectricEnergy electric;
    private PsychicEnergy psychic;
    private IHability fake;

    private IHability electricShock;
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

        electricShock= new ElectricShock("Electric Shock", 0, "Throw a coin. If it's tails, the opponent's selected Pokemon receives x damage",30);
    }

    @Test
    public void EnergyBurnCenterTest(){
        assertEquals(true, Blue.getState().isInInitialState());
        assertEquals("Energy Burn",energyBurn.getName());

    }

    @Test
    public void EnergyBurnFirePokemonFunctionnalities(){
        charmander.setAbility(energyBurn);
        charmander.receiveEnergy(fighting);
        charmander.receiveEnergy(water);
        charmander.receiveEnergy(plant);
        charmander.receiveEnergy(plant);

        Blue.takeCard(charmander);
        Blue.setPlaying(true);
        Blue.setState(new FirstState());
        Blue.playCard(charmander);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn);

        assertEquals(4, charmander.getQuantityofAnEnergy(fire));


    }

    @Test
    public void EnergyBurnWaterPokemonFunctionnalities(){
        squirtle.setAbility(energyBurn);
        squirtle.receiveEnergy(fighting);
        squirtle.receiveEnergy(fire);
        squirtle.receiveEnergy(plant);
        squirtle.receiveEnergy(plant);

        Blue.takeCard(squirtle);
        Blue.setPlaying(true);
        Blue.setState(new FirstState());
        Blue.playCard(squirtle);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn);

        assertEquals(4, squirtle.getQuantityofAnEnergy(water));


    }

    @Test
    public void EnergyBurnPlantPokemonFunctionnalities(){
        bulbasaur.setAbility(energyBurn);
        assertEquals(energyBurn, bulbasaur.getAbilitiesList().get(0));
        bulbasaur.receiveEnergy(fighting);
        bulbasaur.receiveEnergy(fire);
        bulbasaur.receiveEnergy(water);
        bulbasaur.receiveEnergy(water);

        Blue.takeCard( bulbasaur);
        Blue.setPlaying(true);
        Blue.setState(new FirstState());
        Blue.playCard( bulbasaur);


        Blue.enableHability(energyBurn);

        assertEquals(4, bulbasaur.getQuantityofAnEnergy(plant));


    }

    @Test
    public void EnergyBurnElectricPokemonFunctionnalities(){
        pikachu.setAbility(energyBurn);
        pikachu.receiveEnergy(fighting);
        pikachu.receiveEnergy(fire);
        pikachu.receiveEnergy(plant);
        pikachu.receiveEnergy(plant);

        Blue.takeCard(pikachu);
        Blue.setPlaying(true);
        Blue.setState(new FirstState());
        Blue.playCard(pikachu);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn);

        assertEquals(4, pikachu.getQuantityofAnEnergy(electric));


    }

    @Test
    public void EnergyBurnPsychicPokemonFunctionnalities(){
        abra.setAbility(energyBurn);
        abra.receiveEnergy(fighting);
        abra.receiveEnergy(fire);
        abra.receiveEnergy(plant);
        abra.receiveEnergy(plant);

        Blue.takeCard(abra);
        Blue.setPlaying(true);
        Blue.setState(new FirstState());
        Blue.playCard(abra);
        Blue.setState(new FirstState());
        Blue.enableHability(energyBurn);

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
        Blue.setState(new FirstState());
        Blue.playCard(mankey);
        Blue.setState(new FirstState());

        Blue.enableHability(energyBurn);

        assertEquals(1, mankey.getQuantityofAnEnergy(fighting));

        Blue.setUsingAbility(false);
        mankey.setAbility(energyBurn);
        Blue.enableHability(energyBurn);

        assertEquals(4, mankey.getQuantityofAnEnergy(fighting));


    }

    @Test
    public void simpleHabilityTest(){
        assertEquals(0, pikachu.getQuantityofAnEnergy(electric));
        assertEquals(0, mankey.getQuantityofAnEnergy(fighting));
        assertEquals(0, charmander.getQuantityofAnEnergy(fire));
        assertEquals(0, bulbasaur.getQuantityofAnEnergy(plant));
        assertEquals(0, squirtle.getQuantityofAnEnergy(water));
        assertEquals(0, abra.getQuantityofAnEnergy(psychic));

        electricShock.enableElectricPokemon(pikachu);
        electricShock.enableFightingPokemon(mankey);
        electricShock.enableFirePokemon(charmander);
        electricShock.enablePlantPokemon(bulbasaur);
        electricShock.enableWaterPokemon(squirtle);
        electricShock.enablePsychicPokemon(abra);

        assertEquals(0, pikachu.getQuantityofAnEnergy(electric));
        assertEquals(0, mankey.getQuantityofAnEnergy(fighting));
        assertEquals(0, charmander.getQuantityofAnEnergy(fire));
        assertEquals(0, bulbasaur.getQuantityofAnEnergy(plant));
        assertEquals(0, squirtle.getQuantityofAnEnergy(water));
        assertEquals(0, abra.getQuantityofAnEnergy(psychic));

    }






}