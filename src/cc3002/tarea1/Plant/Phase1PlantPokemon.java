package cc3002.tarea1.Plant;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase1Pokemon;

import java.util.ArrayList;

/**
 * Class which represents phase1 plant pokemons
 * @author Adèle Bourgeix
 */
public class Phase1PlantPokemon extends APlantPokemon implements IPhase1Pokemon {

    public Phase1PlantPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }
}
