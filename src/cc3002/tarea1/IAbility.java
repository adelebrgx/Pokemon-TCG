package cc3002.tarea1;

import cc3002.tarea1.Electric.IElectricPokemon;
import cc3002.tarea1.Fighting.IFightingPokemon;
import cc3002.tarea1.Fire.IFirePokemon;
import cc3002.tarea1.Plant.IPlantPokemon;
import cc3002.tarea1.Psychic.IPsychicPokemon;
import cc3002.tarea1.Water.IWaterPokemon;

import java.util.HashMap;

/**
 * Interface which represents the game's abilities
 * @author Adèle Bourgeix
 */
public interface IAbility {

    /** Getter for the name of the ability
     * @return string which the ability's name
     */
    String getName();

    /** Method which returns the energies a Pokemon must posess to use an ability
     * @return return HashMap with the type and quantity of energies needed
     */
    HashMap<String, Integer> getCosts();


    /** When initializing an ability, energies can be assigned which will be needed by a pokemon to use the ability
     * @param energy type of energy set to the ability
     * @param quantity quantity of energy set to the ability
     */
    void setEnergyCost(String energy, int quantity);

    /**
     * Method to represent the effect of an ability over a Pokemon once it's activated. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is enabled
     */
    void affect(IPokemon pokemon);


    /**
     * When the Player enables an ability during the game.
     * @param p Player which enables the ability
     */
    void isBeingEnabled(Player p);

    /**
     * Enabling a Pokemon of type Fire. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enableFirePokemon(IFirePokemon pokemon);

    /**
     * Enabling a Pokemon of type Water. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enableWaterPokemon(IWaterPokemon pokemon);

    /**
     * Enabling a Pokemon of type Plant. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enablePlantPokemon(IPlantPokemon pokemon);

    /**
     * Enabling a Pokemon of type Electric. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enableElectricPokemon(IElectricPokemon pokemon);

    /**
     * Enabling a Pokemon of type Psychic. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enablePsychicPokemon(IPsychicPokemon pokemon);

    /**
     * Enabling a Pokemon of type Fighting. Because some abilities depend on Pokemon's type. (cc Visitor Pattern)
     * @param pokemon Pokemon which ability is being enabled
     */
    public void enableFightingPokemon(IFightingPokemon pokemon);
}
