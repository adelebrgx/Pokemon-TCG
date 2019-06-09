package cc3002.tarea1.Fire;

import cc3002.tarea1.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Class which represents phase2 fire pokemons
 * @author Adèle Bourgeix
 */


public class Phase2FirePokemon extends AFirePokemon implements IPhase2Pokemon {

    public Phase2FirePokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }

    @Override
    public void beingPlayedBy(Player player){
        boolean result= this.checkEvolution(player);
        if (result==false){
            System.out.println("there is no phase1 to be replaced by the following Pokemon");
        }
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectPhase2Pokemon(this);
    }
}
