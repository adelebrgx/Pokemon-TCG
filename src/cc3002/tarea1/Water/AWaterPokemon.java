package cc3002.tarea1.Water;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Abstract class which extends the notion of Pokemon to a Pokemon of type water
 * @author Adèle Bourgeix
 */
public abstract class AWaterPokemon extends APokemon implements IWaterPokemon{


    /** Constructor of a water type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAbilities attacks pokemon can perform
     */
    public AWaterPokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveWaterAttack(anattack);
    }

    @Override
    public String type(){
        return "Water";
    }

    @Override
    public void receivePlantAttack(Attack anAttack){ this.receiveWeaknessAttack(anAttack); }
    @Override
    public void receiveElectricAttack(Attack anAttack){ this.receiveWeaknessAttack(anAttack);}
    @Override
    public void receiveFightingAttack(Attack anAttack){ this.receiveResistantAttack(anAttack); }

    @Override
    public void receiveAbility(IAbility ability){
        ability.enableWaterPokemon(this);
    }


}
