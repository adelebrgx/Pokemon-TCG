package cc3002.tarea1.Water;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic water pokemons. When it's being inspected, it notifies the Pokemon's basic.
 * @author Adèle Bourgeix
 */

public class BasicWaterPokemon extends AWaterPokemon implements IBasicPokemon {

    public BasicWaterPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectBasicPokemon(this);
    }
}
