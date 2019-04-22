package cc3002.tarea1.Electric;


import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;


public class ElectricAttack extends AAttack {

    public ElectricAttack(String aName, int abaseDamage, String aDescription){
        super(aName,abaseDamage,aDescription);
    }

    @Override
    public void performAttack(IPokemon aPokemon) {
        aPokemon.receiveElectricAttack(this);
    }
}
