package cc3002.tarea1.Psychic;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic psychic pokemons. When it's being inspected, it notifies the Pokemon's basic.
 * @author Adèle Bourgeix
 */
public class BasicPsychicPokemon extends APsychicPokemon implements IBasicPokemon {


    /**
     * Constructor for Basic Psychic Pokemons
     * @param someName a name
     * @param somePokedexID an ID
     * @param someHP an HP
     * @param someAbilities abilities
     */
    public BasicPsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectBasicPokemon(this);
    }


}
