package cc3002.tarea1.Water;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase2 water pokemons
 * @author Adèle Bourgeix
 */


public class Phase2WaterPokemon extends AWaterPokemon implements IPhase2Pokemon {

    public Phase2WaterPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
