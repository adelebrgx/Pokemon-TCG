package cc3002.tarea1.Psychic;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase1Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase1 psychic pokemons
 * @author Adèle Bourgeix
 */
public class Phase1PsychicPokemon extends APsychicPokemon implements IPhase1Pokemon {

    public Phase1PsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
