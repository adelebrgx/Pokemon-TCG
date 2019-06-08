package cc3002.tarea1.Electric;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase2 electric pokemons
 * @author Adèle Bourgeix
 */

public class Phase2ElectricPokemon extends AElectricPokemon implements IPhase2Pokemon {

    public Phase2ElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
