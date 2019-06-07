package cc3002.tarea1;

/**
 * Abstract class representing trainer's cards and all the actions associated
 * @author Adèle Bourgeix
 */
public abstract class ATrainerCard implements ITrainerCard{
    private String name;
    private String description;

    /**
     * Conctructor for the trainer's cards
     * @param aName name of the given card
     * @param aDescription description to the given card
     */
    public ATrainerCard(String aName, String aDescription){
        this.name= name;
        this.description=description;
    }

    /**
     * getter to the given card's name
     * @return a String which is the card's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * getter to the given's card description
     * @return a String which is the card's description
     */
    public String getDescription(){
        return this.description;
    }
}
