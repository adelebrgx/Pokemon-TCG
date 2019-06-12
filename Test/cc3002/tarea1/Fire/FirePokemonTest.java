package cc3002.tarea1.Fire;
import cc3002.tarea1.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FirePokemonTest {
    private IPokemon charmander;
    private IPokemon charmeleon;
    private IPokemon charizard;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack firepunch;
    private Player Blue;
    private TrainingCenter trainingCenter;
    private IEnergy fire;


    @Before
    public void setUp() {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        firepunch=new BasicAttack("Fire Punch",40,"Attack of pokemon type: fire");
        charmander=new BasicFirePokemon("Charmander",4,50,new ArrayList<>());
        charmeleon=new Phase1FirePokemon("Charmeleon",5,70,new ArrayList<>(Arrays.asList(flamethrower)));
        charizard=new Phase2FirePokemon("Charizard", 6, 90, new ArrayList<>());
        Blue=new Player("Blue");
        fire=new FireEnergy();
        trainingCenter= new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 20);
    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Charmander", charmander.getName());
        assertEquals(4, charmander.getPokedexID());
        assertEquals(50,charmander.getHP());
        assertEquals("Fire", charmander.type());
    }

    @Test
    public void selectAttackTest(){

        assertEquals("Flame Thrower", charmeleon.getAbilitiesList().get(0).getName());
        charmeleon.setAbility(firepunch);
        charmander.setAbility(firepunch);
        assertEquals("Fire Punch", charmeleon.getAbilitiesList().get(1).getName());
        assertEquals("Fire Punch", charmander.getAbilitiesList().get(0).getName());
        assertEquals(2, charmeleon.getAbilitiesList().size());
        assertEquals(1, charmander.getAbilitiesList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveWaterAttack(aquajet);
        assertEquals(0, charmander.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveFireAttack(flamethrower);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveElectricAttack(thundershock);
        assertEquals(15, charmander.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receiveFightingAttack(karatechop);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receivePlantAttack(tackle);
        assertEquals(20, charmander.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(50, charmander.getHP());
        charmander.receivePsychicAttack(shadowbowl);
        assertEquals(10, charmander.getHP());
    }


    @Test
    public void hurtAnotherPokemon(){
        charmeleon.hurt(charmander, flamethrower);
        assertEquals(20, charmander.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){

        charmander.receiveEnergy(fire);
        Blue.takeCard(charmander);
        Blue.takeCard(charmeleon);
        charmander.beingPlayedBy(Blue);

        assertEquals(1, charmander.getQuantityofAnEnergy(fire));
        assertEquals(0, charmeleon.getQuantityofAnEnergy(fire));


        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charmeleon.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmeleon, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());

        //energies are being transfered to charmander
        assertEquals(0, charmander.getQuantityofAnEnergy(fire));
        assertEquals(1, charmeleon.getQuantityofAnEnergy(fire));


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.takeCard(charmander);
        Blue.takeCard(charmeleon);
        charmeleon.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.takeCard(charmander);
        Blue.takeCard(charmeleon);
        Blue.takeCard(charizard);
        charmander.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charmeleon.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmeleon, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());
        charizard.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charizard, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.takeCard(charmander);
        Blue.takeCard(charmeleon);
        Blue.takeCard(charizard);
        charmander.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        charizard.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(charmander, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }

    @Test
    public void InspectionTest(){
        charmander.isBeingInspected(trainingCenter);
        charmeleon.isBeingInspected(trainingCenter);
        charizard.isBeingInspected(trainingCenter);
        assertEquals(50,charmander.getHP());
        // Training Center adds x HP to Pokemons of Phase1 and 2
        assertEquals(90,charmeleon.getHP());
        assertEquals(110,charizard.getHP());
    }


}