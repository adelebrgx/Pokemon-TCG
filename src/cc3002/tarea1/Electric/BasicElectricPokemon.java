package cc3002.tarea1.Electric;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IBasicPokemon;

import java.util.ArrayList;

/**
 * Class which represents basic electric pokemons
 * @author Adèle Bourgeix
 */
public class BasicElectricPokemon extends AElectricPokemon implements IBasicPokemon {

    public BasicElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
