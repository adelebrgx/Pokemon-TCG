package cc3002.tarea1;

/**
 * Abstract class representing trainer's cards and all the actions associated
 * @author Adèle Bourgeix
 */
public abstract class ATrainerCard extends ACard implements ITrainerCard {
    private String name;
    private String description;

    /**
     * Conctructor for the trainer's cards
     * @param aName name of the given card
     * @param aDescription description to the given card
     */
    public ATrainerCard(String aName, String aDescription){
        super(aName);
        this.description=aDescription;
    }

    /**
     * getter to the given's card description
     * @return a String which is the card's description
     */
    public String getDescription(){
        return this.description;
    }


    @Override
    public void inspectBasicPokemon(IBasicPokemon basic){}

    @Override
    public void inspectPhase1Pokemon(IPhase1Pokemon phase1){}

    @Override
    public void inspectPhase2Pokemon(IPhase2Pokemon phase2){}


    public void beingPlayedBy(Player player){
        player.eliminate(this);
    }
}
