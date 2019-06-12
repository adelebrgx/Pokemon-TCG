package cc3002.tarea1.Electric;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IAbility;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

/** Abstract class which extends the notion of Pokemon to a Pokemon of type electric
 * @author Adèle Bourgeix
 */
public abstract class AElectricPokemon extends APokemon implements IElectricPokemon{

    /** Constructor of a electric type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAbilities abilities the Pokemon posess
     */
    public AElectricPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveElectricAttack(anattack);
    }

    @Override
    public String type(){
        return "Electric";
    }

    @Override
    public void receiveFightingAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }

    @Override
    public void receiveAbility(IAbility ability){
        ability.enableElectricPokemon(this);
    }


}
