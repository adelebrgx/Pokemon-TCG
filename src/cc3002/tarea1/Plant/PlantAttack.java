package cc3002.tarea1.Plant;

import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;

public class PlantAttack extends AAttack {
    public PlantAttack(String aName, int abaseDamage, String aDescription){
        super(aName,abaseDamage,aDescription);
    }

    @Override
    public void performAttack(IPokemon aPokemon) {
        aPokemon.receivePlantAttack(this);
    }
}
