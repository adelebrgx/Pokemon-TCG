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
public interface IHability {

    /** Getter for the name of the attack
     * @return string which the attack's name
     */
    String getName();

    /** Method which returns the energies a Pokemon must posess to perform an attack
     * @return return HashMap with the type and quantity of energies needed
     */
    HashMap<String, Integer> getCosts();

    /** Returns the quantity of one type of energy owned by a pokemon
     * @param energy energy looked for among the pokemon's energies associated
     * @return Quantity needed of one type of energy
     */
    int quantityOneEnergy(IEnergy energy);

    /** When initializing an attack, energies can be assigned which will be needed by a pokemon to perform the attack
     * @param energy type of energy set to the attack
     * @param quantity quantity of energy set to the attack
     */
    void setEnergyCost(String energy, int quantity);

    void affect(IPokemon pokemon);

    void isBeingEnabled(Player p);


    public void enableFirePokemon(IFirePokemon pokemon);
    public void enableWaterPokemon(IWaterPokemon pokemon);
    public void enablePlantPokemon(IPlantPokemon pokemon);
    public void enableElectricPokemon(IElectricPokemon pokemon);
    public void enablePsychicPokemon(IPsychicPokemon pokemon);
    public void enableFightingPokemon(IFightingPokemon pokemon);
}
