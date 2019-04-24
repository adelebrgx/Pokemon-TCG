package cc3002.tarea1;

/**
 * Interface which implements the behavior of card of type energy
 * @author Adèle Bourgeix
 */
public interface IEnergy extends ICard {

    /** Getter to the energy's name
     * @return
     */
    public String getName();

    /** Getter of the energy's type which can be: fire, water, plant, electric, psychic or fighting
     * @return
     */
    public String type();

    /** What happens when an energy card is played by th player toward his selected pokemon
     * @param inAction player which plays the energy card during the game
     */
    public void beingPlayedBy(Entrenador inAction);
}
