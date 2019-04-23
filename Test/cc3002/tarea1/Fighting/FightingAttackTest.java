package cc3002.tarea1.Fighting;

import cc3002.tarea1.Electric.ElectricAttack;
import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FightingAttackTest {
    private IAttack karatechop;
    private IEnergy fighting;
    @Before
    public void setUp() throws Exception {
        karatechop=new FightingAttack("Karate Chop",30,"Attack of type: fighting");
        fighting= new ElectricEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        karatechop.setEnergyCost(fighting.type(),3);

        assertEquals("Karate Chop", karatechop.getName());
        assertEquals(30, karatechop.getBaseDamage());
        assertEquals("Attack of type: fighting", karatechop.getDescription());
        assertEquals(3, karatechop.quantityOneEnergy(fighting));

    }
}