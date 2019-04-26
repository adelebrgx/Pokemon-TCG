package cc3002.tarea1.Plant;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;

/** Class which extends the notion of Pokemon to a Pokemon of type plant
 * @author Adèle Bourgeix
 */
public class PlantPokemon extends APokemon {

    /**Constructor of a plant type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAttacks attacks pokemon can perform
     */
    public PlantPokemon(String someName, int somePokedexID, int someHP, ArrayList<Attack> someAttacks) {
        super(someName, somePokedexID, someHP, someAttacks);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receivePlantAttack(anattack);
    }

    @Override
    public String type(){
        return "Plant";
    }
    @Override
    public void receiveFireAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveResistantAttack(anAttack);
    }

}
