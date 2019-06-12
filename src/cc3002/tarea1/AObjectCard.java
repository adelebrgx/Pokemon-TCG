package cc3002.tarea1;

/**
 * Object Card abstract class which implements the IObjectCard interface and extends the ATrainerCard abstract class
 * @author Adèle Bourgeix
 */
public abstract class AObjectCard extends ATrainerCard implements IObjectCard {

    public AObjectCard(String aName, String aDescription){super(aName,aDescription);}

    public void beingPlayedBy(Player player){
        if(player.getSelectedPokemon().getObjectCardAssociated()!=null){
            player.getLostCards().add(this);
        }
        player.getSelectedPokemon().associateObjectCard(this);

    }


}
