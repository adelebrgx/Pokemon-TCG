package cc3002.tarea1.Fighting;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic fighting pokemons. When it's being inspected, it notifies the Pokemon's basic.
 * @author Adèle Bourgeix
 */
public class BasicFightingPokemon extends AFightingPokemon implements IBasicPokemon {

    public BasicFightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectBasicPokemon(this);
    }
}
