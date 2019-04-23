package cc3002.tarea1.Psychic;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.Water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PsychicAttackTest {
    private IAttack shadowbowl;
    private IEnergy water;
    private IEnergy psychic;
    @Before
    public void setUp() throws Exception {
        shadowbowl=new PsychicAttack("Shadow Bowl",40,"Attack of type: psychic");
        water= new WaterEnergy();
        psychic=new PsychicEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        shadowbowl.setEnergyCost(water.type(),1);
        shadowbowl.setEnergyCost(psychic.type(),2);

        assertEquals("Shadow Bowl", shadowbowl.getName());
        assertEquals(40, shadowbowl.getBaseDamage());
        assertEquals("Attack of type: psychic", shadowbowl.getDescription());
        assertEquals(1, shadowbowl.quantityOneEnergy(water));
        assertEquals(2, shadowbowl.quantityOneEnergy(psychic));

    }
}