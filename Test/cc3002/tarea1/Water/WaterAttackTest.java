package cc3002.tarea1.Water;

import cc3002.tarea1.IAttack;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.Plant.PlantEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterAttackTest {
    private IAttack aquajet;
    private IEnergy plant;
    private IEnergy water;
    @Before
    public void setUp() throws Exception {
        aquajet=new WaterAttack("Aqua Jet",20,"Attack of type: water");
        plant= new PlantEnergy();
        water=new WaterEnergy();
    }

    @Test
    public void SimplePokemonTest(){

        aquajet.setEnergyCost(plant.type(),1);
        aquajet.setEnergyCost(water.type(),4);

        assertEquals("Aqua Jet", aquajet.getName());
        assertEquals(20, aquajet.getBaseDamage());
        assertEquals("Attack of type: water", aquajet.getDescription());
        assertEquals(1, aquajet.quantityOneEnergy(plant));
        assertEquals(4, aquajet.quantityOneEnergy(water));

    }
}