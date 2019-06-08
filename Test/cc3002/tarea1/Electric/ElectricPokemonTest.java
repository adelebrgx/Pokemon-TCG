package cc3002.tarea1.Electric;
import cc3002.tarea1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ElectricPokemonTest {
    private IPokemon pikachu;
    private IPokemon raichu;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack discharge;
    private Player Blue;


    @Before
    public void setUp(){
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        discharge=new BasicAttack("Discharge",50,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        pikachu=new BasicElectricPokemon("Pikachu",25,90,new ArrayList<>());
        raichu=new Phase1ElectricPokemon("Raichu", 26, 110, new ArrayList<>(Arrays.asList(discharge)));
        Blue=new Player("Blue");

    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Pikachu", pikachu.getName());
        assertEquals(25, pikachu.getPokedexID());
        assertEquals(90,pikachu.getHP());
        assertEquals("Electric", pikachu.type());
    }
    @Test
    public void selectAttackTest(){

        assertEquals("Discharge", raichu.getAttacksList().get(0).getName());
        raichu.setAttack(thundershock);
        pikachu.setAttack(thundershock);
        assertEquals("Thundershock", raichu.getAttacksList().get(1).getName());
        assertEquals("Thundershock", pikachu.getAttacksList().get(0).getName());
        assertEquals(2, raichu.getAttacksList().size());
        assertEquals(1, pikachu.getAttacksList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveWaterAttack(aquajet);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFireAttack(flamethrower);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveElectricAttack(thundershock);
        assertEquals(55, pikachu.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFightingAttack(karatechop);
        assertEquals(30, pikachu.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePlantAttack(tackle);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePsychicAttack(shadowbowl);
        assertEquals(50, pikachu.getHP());
    }

    @Test
    public void PokemonPlayedTest(){

        Blue.drawCard(pikachu);
        Blue.drawCard(pikachu);
        pikachu.beingPlayedBy(Blue);
        pikachu.beingPlayedBy(Blue);
        assertEquals("Pikachu", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }

    @Test
    public void hurtAnotherPokemon(){
        raichu.hurt(pikachu, discharge);
        assertEquals(40, pikachu.getHP());
    }
}