package cc3002.tarea1.Fire;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents phase1 fire pokemons. When it's being inspected, it notifies the Pokemon's phase1.
 * @author Adèle Bourgeix
 */
public class Phase1FirePokemon extends AFirePokemon implements IPhase1Pokemon {

    public Phase1FirePokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
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
    public void isBeingInspected(ITrainerCard card){
        card.inspectPhase1Pokemon(this);
    }
}
