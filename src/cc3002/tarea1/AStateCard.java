package cc3002.tarea1;

/**
 * States Card abstract class which implements the interface IStateCard and extends the abstrct class AStateCard
 * @author Adèle Bourgeix
 */
public abstract class AStateCard extends ATrainerCard implements IStateCard {

    /**
     * Constructor for state Cards
     * @param aName name of the state card
     * @param aDescription description of the state card
     */
    public AStateCard(String aName, String aDescription){super(aName,aDescription);}


    @Override
    public void beingPlayedBy(Player inAction){
        if(inAction.getController().getStateCard()!=null){
            inAction.eliminate(this);
        }
        inAction.getController().setStateCard(this);

    }
}
