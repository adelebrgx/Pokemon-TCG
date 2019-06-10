package cc3002.tarea1.Psychic;

import cc3002.tarea1.Attack;
import cc3002.tarea1.IBasicPokemon;
import cc3002.tarea1.IStateCard;

import java.util.ArrayList;

/**
 * Class which represents basic psychic pokemons
 * @author Adèle Bourgeix
 */
public class BasicPsychicPokemon extends APsychicPokemon implements IBasicPokemon {

    public BasicPsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }

    @Override
    public void isBeingInspected(IStateCard card){
        card.inspectBasicPokemon(this);
    }


}