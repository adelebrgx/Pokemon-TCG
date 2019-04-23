package cc3002.tarea1.Fire;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireAttackTest {
    private IAttack flamethrower;
    private IEnergy fire;
    @Before
    public void setUp() throws Exception {
        flamethrower=new FireAttack("Flame Thrower",10,"Attack of type: fire");
        fire= new FireEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        flamethrower.setEnergyCost(fire.type(),1);

        assertEquals("Flame Thrower", flamethrower.getName());
        assertEquals(10, flamethrower.getBaseDamage());
        assertEquals("Attack of type: fire", flamethrower.getDescription());
        assertEquals(1, flamethrower.quantityOneEnergy(fire));

    }
}