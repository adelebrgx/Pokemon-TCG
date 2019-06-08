package cc3002.tarea1.Fighting;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IBasicPokemon;

import java.util.ArrayList;

/**
 * Class which represents basic fighting pokemons
 * @author Adèle Bourgeix
 */
public class BasicFightingPokemon extends AFightingPokemon implements IBasicPokemon {

    public BasicFightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
