package cc3002.tarea1.Psychic;

import cc3002.tarea1.AAttack;
import cc3002.tarea1.IPokemon;

public class PsychicAttack extends AAttack {
    public PsychicAttack(String aName, int abaseDamage, String aDescription){
        super(aName,abaseDamage,aDescription);
    }

    @Override
    public void performAttack(IPokemon aPokemon) {
        aPokemon.receivePsychicAttack(this);
    }
}
