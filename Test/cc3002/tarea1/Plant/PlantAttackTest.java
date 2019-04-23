package cc3002.tarea1.Plant;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.Psychic.PsychicEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlantAttackTest {
    private IAttack tackle;
    private IEnergy plant;
    private IEnergy psychic;
    @Before
    public void setUp() throws Exception {
        tackle=new PlantAttack("Tackle",20,"Attack of type: plant");
        plant= new PlantEnergy();
        psychic=new PsychicEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        tackle.setEnergyCost(plant.type(),4);
        tackle.setEnergyCost(psychic.type(),2);

        assertEquals("Tackle", tackle.getName());
        assertEquals(20, tackle.getBaseDamage());
        assertEquals("Attack of type: plant", tackle.getDescription());
        assertEquals(4, tackle.quantityOneEnergy(plant));
        assertEquals(2, tackle.quantityOneEnergy(psychic));

    }
}