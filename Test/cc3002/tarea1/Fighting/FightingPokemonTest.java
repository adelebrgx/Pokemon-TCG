package cc3002.tarea1.Fighting;
import cc3002.tarea1.*;

import cc3002.tarea1.Fire.Phase2FirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FightingPokemonTest {
    private IPokemon chimchar;
    private IPokemon monferno;
    private IPokemon infernape;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack lowkick;
    private Player Blue;
    private List<ICard> deck;

    @Before
    public void setUp()  {
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        lowkick=new BasicAttack("Low Kick",40,"Attack of pokemon type: fighting");
        chimchar =new BasicFightingPokemon("Chimchar",390,60,new ArrayList<>());
        monferno =new Phase1FightingPokemon("Monferno", 391, 100,new ArrayList<>(Arrays.asList(karatechop)));
        infernape= new Phase2FightingPokemon("Infernape",392, 130, new ArrayList<>());
        Blue=new Player("Blue");
        deck=new ArrayList<>();
    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Chimchar", chimchar.getName());
        assertEquals(390, chimchar.getPokedexID());
        assertEquals(60, chimchar.getHP());
        assertEquals("Fighting", chimchar.type());
    }

    @Test
    public void selectAttackTest(){

        assertEquals("Karate Chop", monferno.getAttacksList().get(0).getName());
        monferno.setAttack(lowkick);
        chimchar.setAttack(lowkick);
        assertEquals("Low Kick", monferno.getAttacksList().get(1).getName());
        assertEquals("Low Kick", chimchar.getAttacksList().get(0).getName());
        assertEquals(2, monferno.getAttacksList().size());
        assertEquals(1, chimchar.getAttacksList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receiveWaterAttack(aquajet);
        assertEquals(30, chimchar.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receiveFireAttack(flamethrower);
        assertEquals(30, chimchar.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receiveElectricAttack(thundershock);
        assertEquals(25, chimchar.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receiveFightingAttack(karatechop);
        assertEquals(30, chimchar.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receivePlantAttack(tackle);
        assertEquals(0, chimchar.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(60, chimchar.getHP());
        chimchar.receivePsychicAttack(shadowbowl);
        assertEquals(0, chimchar.getHP());
    }


    @Test
    public void hurtAnotherPokemon(){
        monferno.hurt(chimchar, karatechop);
        assertEquals(30, chimchar.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){
        Blue.drawCard(chimchar);
        Blue.drawCard(monferno);
        chimchar.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(chimchar, Blue.getSelectedPokemon());
        monferno.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(monferno, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.drawCard(chimchar);
        Blue.drawCard(monferno);
        monferno.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.drawCard(chimchar);
        Blue.drawCard(monferno);
        Blue.drawCard(infernape);
        chimchar.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(chimchar, Blue.getSelectedPokemon());
        monferno.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(monferno, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());
        infernape.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(infernape, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.drawCard(chimchar);
        Blue.drawCard(monferno);
        Blue.drawCard(infernape);
        chimchar.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(chimchar, Blue.getSelectedPokemon());
        infernape.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(chimchar, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }
}