package cc3002.tarea1.Psychic;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

/**
 * Class which extends the notion of Pokemon to a Pokemon of type water
 * @author Adèle Bourgeix
 */
public class PsychicPokemon extends APokemon {


    /**Constructor of a psychic type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAttacks attacks pokemon can perform
     */
    public PsychicPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
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
}
