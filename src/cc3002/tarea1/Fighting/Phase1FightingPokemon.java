package cc3002.tarea1.Fighting;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents phase1 fighting pokemons. When it's being inspected, it notifies the Pokemon's phase1.
 * @author Adèle Bourgeix
 */
public class Phase1FightingPokemon extends AFightingPokemon implements IPhase1Pokemon {

    /**
     * Constructor for Phase1 Fighting Pokemons
     * @param someName a name
     * @param somePokedexID an ID
     * @param someHP an HP
     * @param someAbilities abilities
     */
    public Phase1FightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
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
