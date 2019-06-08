package cc3002.tarea1;

/**
 * Interface which implements the behavior of card of type energy
 * @author Adèle Bourgeix
 */
public interface IEnergy extends ICard {


    /** Getter of the energy's type which can be: fire, water, plant, electric, psychic or fighting
     * @return a string which is the type of energy
     */
    String type();

    /** What happens when an energy card is played by th player toward his selected pokemon
     * @param inAction player which plays the energy card during the game
     */
    void beingPlayedBy(Player inAction);
}
