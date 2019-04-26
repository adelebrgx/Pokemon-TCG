package cc3002.tarea1.entrenador;

import cc3002.tarea1.Attack;
import cc3002.tarea1.Player;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import cc3002.tarea1.Water.WaterPokemon;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.Electric.ElectricPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EntrenadorTest {

    private Player Red;
    private Player Blue;
    private IPokemon charmander;
    private IPokemon squirtle;
    private IPokemon abra;
    private IPokemon bulbasaur;
    private IPokemon mankey;
    private IPokemon pikachu;
    private IEnergy plant;
    private IEnergy water;
    private IEnergy fire;
    private IEnergy fighting;
    private Attack torpedo;


    @Before
    public void setUp() throws Exception {
    Red= new Player("Red");
    Blue= new Player("Blue");

    charmander=new FirePokemon("Charmander",4,50,new ArrayList<>());
    squirtle= new WaterPokemon("Squirtle", 7, 50,new ArrayList<>());
    abra= new PsychicPokemon("Abra", 7, 50,new ArrayList<>());
    bulbasaur=new PlantPokemon("Bulbasaur",1,50,new ArrayList<>());
    mankey=new FightingPokemon("Mankey",56,60,new ArrayList<>());
    pikachu=new ElectricPokemon("Pikachu",25,70,new ArrayList<>());

    plant= new PlantEnergy();
    fire=new FireEnergy();
    water=new WaterEnergy();
    fighting=new FightingEnergy();

    torpedo= new Attack("Torpedo", 30, "a Whip Attack");
    }

    @Test
    public void SimpleEntrenadorTest(){
        String expectedNameRed="Red";
        String expectedNameBlue="Blue";
        assertEquals(expectedNameRed, Red.getName());
        assertEquals(expectedNameBlue, Blue.getName());

    }

    @Test
    public void addPokemontoBankTest(){
        Red.playCard(pikachu);
        assertEquals(0,Red.getBank().size());
        Red.drawCard(charmander);
        Red.drawCard(squirtle);

        Red.addPokemontoBank(charmander);
        Red.addPokemontoBank(squirtle);
        Red.selectPokemon(pikachu);


        assertEquals(0,Red.getBank().indexOf(charmander));
        assertEquals("Squirtle",Red.getBank().get(1).getName());
        assertEquals("Charmander",Red.getBank().get(0).getName());
        assertEquals("Charmander", Red.getSelectedPokemon().getName());
        assertEquals(2, Red.getBank().size());

    }

    @Test
    public void selectPokemonTest(){
        Red.drawCard(charmander);
        Red.drawCard(squirtle);

        Red.selectPokemon(squirtle);


        assertEquals("Squirtle",Red.getBank().get(0).getName());
        assertEquals("Squirtle", Red.getSelectedPokemon().getName());

        Red.addPokemontoBank(charmander);
        Red.selectPokemon(charmander);

        assertEquals("Charmander",Red.getSelectedPokemon().getName());
        assertEquals("Squirtle",Red.getBank().get(1).getName() );

    }
    @Test
    public void playPokemonCardTest(){
        Red.drawCard(charmander);
        Red.drawCard(abra);
        Red.playCard(charmander);

        assertEquals("Charmander",Red.getSelectedPokemon().getName());

        Red.playCard(abra);
        assertEquals("Charmander",Red.getSelectedPokemon().getName());
        assertEquals("Charmander",Red.getBank().get(0).getName());
        assertEquals("Abra",Red.getBank().get(1).getName());

    }

    @Test
    public void playEnergyCardTest(){

        Red.drawCard(charmander);
        Red.drawCard(water);
        Red.drawCard(fire);
        Red.drawCard(plant);
        Red.playCard(charmander);
        Red.playCard(water);
        Red.playCard(fire);


        assertEquals(1, Red.getSelectedPokemon().getQuantityofAnEnergy(water));
        assertEquals(1, Red.getSelectedPokemon().getQuantityofAnEnergy(fire));
        assertEquals(0, Red.getSelectedPokemon().getQuantityofAnEnergy(plant));
    }

    @Test
    public void attackTest(){
        torpedo.setEnergyCost("Fire", 2);
        torpedo.setEnergyCost("Plant",1);
        Red.drawCard(charmander);
        Red.drawCard(fire);
        Red.drawCard(fire);
        Red.drawCard(plant);
        Blue.drawCard(squirtle);
        Blue.drawCard(bulbasaur);
        Blue.playCard(squirtle);
        Blue.playCard(bulbasaur);
        Red.playCard(charmander);
        assertEquals("Squirtle",Blue.getSelectedPokemon().getName());
        assertEquals(50,Blue.getSelectedPokemon().getHP());
        Red.playCard(fire);
        Red.playCard(fire);
        Red.playCard(plant);
        charmander.setAttack(torpedo);
        Red.useAttack(torpedo,Blue);
        assertEquals(20,Blue.getSelectedPokemon().getHP());
        Red.useAttack(torpedo,Blue);
        assertEquals("Bulbasaur",Blue.getSelectedPokemon().getName() );
        torpedo.setEnergyCost("Fire",1);
        Red.useAttack(torpedo,Blue);
        assertEquals(50,Blue.getSelectedPokemon().getHP());

    }


}