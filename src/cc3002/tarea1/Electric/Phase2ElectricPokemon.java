package cc3002.tarea1.Electric;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IPhase2Pokemon;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class which represents phase2 electric pokemons
 * @author Adèle Bourgeix
 */

public class Phase2ElectricPokemon extends AElectricPokemon implements IPhase2Pokemon {

    public Phase2ElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }



    @Override
    public void beingPlayedBy(Player player){
        boolean result= this.checkEvolution(player);
        if (result==false){
            System.out.println("there is no phase1 to be replaced by the following Pokemon");
        }
    }
}
