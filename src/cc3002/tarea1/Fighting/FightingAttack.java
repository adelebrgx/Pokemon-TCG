package cc3002.tarea1.Fighting;

import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;

public class FightingAttack extends AAttack {
    public FightingAttack(String aName, int abaseDamage, String aDescription) {
        super(aName, abaseDamage, aDescription);
    }

    @Override
    public void performAttack(IPokemon aPokemon) {
        aPokemon.receiveFightingAttack(this);
    }


}
