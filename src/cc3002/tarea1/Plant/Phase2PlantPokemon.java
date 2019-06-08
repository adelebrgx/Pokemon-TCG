package cc3002.tarea1.Plant;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase2 plant pokemons
 * @author Adèle Bourgeix
 */


public class Phase2PlantPokemon extends APlantPokemon implements IPhase2Pokemon {

    public Phase2PlantPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
