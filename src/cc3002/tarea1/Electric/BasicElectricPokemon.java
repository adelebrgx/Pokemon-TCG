package cc3002.tarea1.Electric;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic electric pokemons
 * @author Adèle Bourgeix
 */
public class BasicElectricPokemon extends AElectricPokemon implements IBasicPokemon {

    public BasicElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectBasicPokemon(this);
    }
}
