package cc3002.tarea1.Water;

import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;

public class WaterAttack extends AAttack {

    public WaterAttack(String aName, int abaseDamage, String aDescription){
        super(aName,abaseDamage,aDescription);
    }

    @Override
    public void performAttack(IPokemon aPokemon){
        aPokemon.receiveWaterAttack(this);
    }
}
