package cc3002.tarea1;

/**
 * Interface which implements the logic of a card
 * @author Adèle Bourgeix
 */
public interface ICard {

    /** What happens when a card, whatever its type, is played!
     * @param inAction player which plays the card
     */
    public void beingPlayedBy(Player inAction);
    public String getTitle();
}
