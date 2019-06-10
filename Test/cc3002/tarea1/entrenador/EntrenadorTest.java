package cc3002.tarea1.entrenador;

import cc3002.tarea1.*;
import cc3002.tarea1.Electric.BasicElectricPokemon;
import cc3002.tarea1.Fighting.BasicFightingPokemon;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.BasicFirePokemon;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Plant.BasicPlantPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.BasicPsychicPokemon;
import cc3002.tarea1.Water.BasicWaterPokemon;
import cc3002.tarea1.Water.WaterEnergy;
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
    private ArrayList<ICard> deckSet;


    @Before
    public void setUp() {
    Red= new Player("Red");
    Blue= new Player("Blue");
    deckSet=new ArrayList<>();

    charmander=new BasicFirePokemon("Charmander",4,50,new ArrayList<>());
    squirtle= new BasicWaterPokemon("Squirtle", 7, 50,new ArrayList<>());
    abra= new BasicPsychicPokemon("Abra", 7, 50,new ArrayList<>());
    bulbasaur=new BasicPlantPokemon("Bulbasaur",1,50,new ArrayList<>());
    mankey=new BasicFightingPokemon("Mankey",56,60,new ArrayList<>());
    pikachu=new BasicElectricPokemon("Pikachu",25,70,new ArrayList<>());

    plant= new PlantEnergy();
    fire=new FireEnergy();
    water=new WaterEnergy();
    fighting=new FightingEnergy();

    torpedo= new BasicAttack("Torpedo", 30, "a Whip Attack");
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

        Red.addPokemontoBank(squirtle);


        assertEquals("Squirtle",Red.getBank().get(0).getName());
        assertEquals("Squirtle", Red.getSelectedPokemon().getName());

        Red.addPokemontoBank(charmander);
        Red.selectPokemon(charmander);

        assertEquals("Charmander",Red.getSelectedPokemon().getName());
        assertEquals("Squirtle",Red.getBank().get(1).getName() );

    }

    @Test
    public void initiateDeckTest(){
        deckSet.add(charmander);
        deckSet.add(pikachu);
        deckSet.add(fire);
        Red.initiateDeck(deckSet);
        assertEquals(60,Red.getStack().size());

    }

    @Test
    public void initiatePrimeCardsTest(){
        deckSet.add(charmander);
        deckSet.add(pikachu);
        deckSet.add(fire);
        Red.initiatePrimeCards(deckSet);
        assertEquals(6,Red.getPrimeCards().size());

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

        //energies are being assigned directly to Pokemon because we cannot control what will be the player's input at playing the energy card
        charmander.receiveEnergy(fire);
        charmander.receiveEnergy(fire);
        charmander.receiveEnergy(fire);
        charmander.receiveEnergy(fire);
        charmander.receiveEnergy(plant);
        charmander.receiveEnergy(plant);
        charmander.setAttack(torpedo);
        Red.useAttack(torpedo,Blue);
        assertEquals(20,Blue.getSelectedPokemon().getHP());
        Red.useAttack(torpedo,Blue);
        assertEquals("Bulbasaur",Blue.getSelectedPokemon().getName() );
        Red.useAttack(torpedo,Blue);
        assertEquals(50,Blue.getSelectedPokemon().getHP());

    }


}