package cc3002.tarea1.Electric;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase1Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase1 electric pokemons
 * @author Adèle Bourgeix
 */
public class Phase1ElectricPokemon extends AElectricPokemon implements IPhase1Pokemon {

    public Phase1ElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
