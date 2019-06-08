package cc3002.tarea1.Fire;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;


/**
 * Class which represents phase2 fire pokemons
 * @author Adèle Bourgeix
 */


public class Phase2FirePokemon extends AFirePokemon implements IPhase2Pokemon {

    public Phase2FirePokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
