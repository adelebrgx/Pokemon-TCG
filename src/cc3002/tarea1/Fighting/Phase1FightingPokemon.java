package cc3002.tarea1.Fighting;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase1Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase1 fighting pokemons
 * @author Adèle Bourgeix
 */
public class Phase1FightingPokemon extends AFightingPokemon implements IPhase1Pokemon {

    public Phase1FightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
