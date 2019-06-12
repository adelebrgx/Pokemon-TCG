package cc3002.tarea1;

/**
 * Abstract class which represents the logic of cards and implements the interface ICard
 * @author Adèle Bourgeix
 */
public abstract class ACard implements ICard {

    private String title;


    /**
     * Constructor for Card. All the cards have in common is a title.
     * @param aTitle
     */
    public ACard(String aTitle){
        this.title=aTitle;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
