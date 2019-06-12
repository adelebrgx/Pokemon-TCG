package cc3002.tarea1.Fighting;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic fighting pokemons
 * @author Adèle Bourgeix
 */
public class BasicFightingPokemon extends AFightingPokemon implements IBasicPokemon {

    public BasicFightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectBasicPokemon(this);
    }
}
