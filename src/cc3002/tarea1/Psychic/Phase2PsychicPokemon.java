package cc3002.tarea1.Psychic;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase2 psychic pokemons
 * @author Adèle Bourgeix
 */


public class Phase2PsychicPokemon extends APsychicPokemon implements IPhase2Pokemon {

    public Phase2PsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
