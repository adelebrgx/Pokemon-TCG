package cc3002.tarea1.Fire;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase1Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase1 fire pokemons
 * @author Adèle Bourgeix
 */
public class Phase1FirePokemon extends AFirePokemon implements IPhase1Pokemon {

    public Phase1FirePokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
