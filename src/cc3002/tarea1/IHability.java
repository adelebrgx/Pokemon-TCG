package cc3002.tarea1;

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

    /**
     * What happens when a player activates an ability during the game, ambiguity is solved
     * @param first the player activating the ability
     * @param following the other player involved if other player is involved
     */
    void beingActivated(Player first, Player following);

    void affect(IPokemon pokemon);
}
