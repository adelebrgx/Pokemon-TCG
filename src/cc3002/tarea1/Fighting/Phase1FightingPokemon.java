package cc3002.tarea1.Fighting;

import cc3002.tarea1.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class which represents phase1 fighting pokemons
 * @author Adèle Bourgeix
 */
public class Phase1FightingPokemon extends AFightingPokemon implements IPhase1Pokemon {

    public Phase1FightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void beingPlayedBy(Player player){
        boolean result= this.checkEvolution(player);
        if (result==false){
            System.out.println("there is no basic type to be replaced by the following Pokemon");
        }
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectPhase1Pokemon(this);
    }
}
