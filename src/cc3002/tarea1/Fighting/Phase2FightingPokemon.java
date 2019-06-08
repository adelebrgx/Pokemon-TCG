package cc3002.tarea1.Fighting;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase2 fighting pokemons
 * @author Adèle Bourgeix
 */


public class Phase2FightingPokemon extends AFightingPokemon implements IPhase2Pokemon {

    public Phase2FightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}

