package cc3002.tarea1.Electric;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic electric pokemons. When it's being inspected, it notifies the Pokemon's basic.
 * @author Adèle Bourgeix
 */
public class BasicElectricPokemon extends AElectricPokemon implements IBasicPokemon {

    /**
     * Constructor for Basic Electric Pokemons
     * @param someName a name
     * @param somePokedexID an ID
     * @param someHP an HP
     * @param someAbilities abilities
     */
    public BasicElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectBasicPokemon(this);
    }
}
