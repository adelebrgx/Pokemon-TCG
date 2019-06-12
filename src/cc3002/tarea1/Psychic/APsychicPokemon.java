package cc3002.tarea1.Psychic;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IHability;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

/**
 * Abstract class which extends the notion of Pokemon to a Pokemon of type water
 * @author Adèle Bourgeix
 */
public abstract class APsychicPokemon extends APokemon implements IPsychicPokemon{


    /**Constructor of a psychic type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAbilities attacks pokemon can perform
     */
    public APsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<IHability> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receivePsychicAttack(anattack);
    }

    @Override
    public String type(){
        return "Psychic";
    }

    @Override
    public void receiveFightingAttack(Attack anAttack){
        this.receiveResistantAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }

    @Override
    public void receiveAbility(IHability hability){
        hability.enablePsychicPokemon(this);
    }
}
