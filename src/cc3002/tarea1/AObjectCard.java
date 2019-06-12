package cc3002.tarea1;

/**
 * Object Card abstract class which implements the IObjectCard interface and extends the ATrainerCard abstract class
 * @author Adèle Bourgeix
 */
public abstract class AObjectCard extends ATrainerCard implements IObjectCard {

    /**
     * Constructor for a new Object card
     * @param aName String which is the name of the object Card
     * @param aDescription String which is a description of the card
     */
    public AObjectCard(String aName, String aDescription){super(aName,aDescription);}

    @Override
    public void beingPlayedBy(Player player){
        if(player.getSelectedPokemon().getObjectCardAssociated()!=null){
            player.getLostCards().add(this);
        }
        player.getSelectedPokemon().associateObjectCard(this);

    }



}
