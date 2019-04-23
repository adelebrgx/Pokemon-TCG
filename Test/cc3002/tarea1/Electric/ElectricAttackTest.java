package cc3002.tarea1.Electric;
import cc3002.tarea1.IAttack;

import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricAttackTest {
    private IAttack thundershock;
    private IEnergy electric;
    @Before
    public void setUp() throws Exception {
        thundershock=new ElectricAttack("Thundershock",25,"Attack of type: electric");
        electric= new ElectricEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        thundershock.setEnergyCost(electric.type(),2);

        assertEquals("Thundershock", thundershock.getName());
        assertEquals(25, thundershock.getBaseDamage());
        assertEquals("Attack of type: electric", thundershock.getDescription());
        assertEquals(2, thundershock.quantityOneEnergy(electric));


    }
}