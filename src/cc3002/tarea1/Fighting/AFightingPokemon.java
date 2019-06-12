package cc3002.tarea1.Fighting;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IAbility;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

/**
 * Abstract class which extends the notion of Pokemon to a Pokemon of fighting type
 * @author Adèle Bourgeix
 */
public abstract class AFightingPokemon extends APokemon implements IFightingPokemon{

    /** Constructor of a fighting type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAbilities attacks pokemon can perform
     */
    public AFightingPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveFightingAttack(anattack);
    }

    @Override
    public String type(){
        return "Fighting";
    }

    @Override
    public void receivePlantAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }

    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }

    @Override
    public void receiveAbility(IAbility ability){ ability.enableFightingPokemon(this);
    }
}
