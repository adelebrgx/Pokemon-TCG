package cc3002.tarea1.Fire;

import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;

public class FireAttack extends AAttack {
    public FireAttack(String aName, int abaseDamage, String aDescription){
        super(aName,abaseDamage,aDescription);
    }
    @Override
    public void performAttack(IPokemon aPokemon) {
        aPokemon.receiveFireAttack(this);
    }
}
