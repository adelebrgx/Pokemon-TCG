package cc3002.tarea1.Fire;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IBasicPokemon;
import cc3002.tarea1.IHability;
import cc3002.tarea1.IStateCard;

import java.util.ArrayList;

/**
 * Class which represents basic fire pokemons
 * @author Adèle Bourgeix
 */
public class BasicFirePokemon extends AFirePokemon implements IBasicPokemon {

    public BasicFirePokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectBasicPokemon(this);
    }
}
