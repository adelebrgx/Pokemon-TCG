package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackTest {
    private Attack VineWhip;
    private IEnergy plant;

    @Before
    public void setUp() throws Exception {
        VineWhip= new Attack("Vine Whip", 10, "a Whip Attack");




    }

    @Test
    public void SimpleAttackTest(){
        VineWhip.setEnergyCost(plant, 2);


    }




}