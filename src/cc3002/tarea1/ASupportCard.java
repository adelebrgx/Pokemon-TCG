package cc3002.tarea1;

/**
 * Support Card abstract class which implements the ISupportCard interface and extends the ATrainerCard abstract class
 * @author Adèle Bourgeix
 */
public abstract class ASupportCard extends ATrainerCard implements ISupportCard{

    /**
     * Constructor for support cards
     * @param aName name to the support card
     * @param aDescription description to the support card
     */
    public ASupportCard(String aName, String aDescription){super(aName, aDescription);}

    @Override
    public void beingPlayedBy(Player player){
        player.eliminate(this);
        player.setHasPlayedSupport(true);
    }





}
