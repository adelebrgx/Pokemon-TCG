package cc3002.tarea1.Electric;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents phase2 electric pokemons
 * @author Adèle Bourgeix
 */

public class Phase2ElectricPokemon extends AElectricPokemon implements IPhase2Pokemon {

    public Phase2ElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }



    @Override
    public void beingPlayedBy(Player player){
        boolean result= this.checkEvolution(player);
        if (result==false){
            System.out.println("there is no phase1 to be replaced by the following Pokemon");
        }
    }

    @Override
    public void isBeingInspected(IStateCard card ){
        card.inspectPhase2Pokemon(this);
    }
}
