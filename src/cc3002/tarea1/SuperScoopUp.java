package cc3002.tarea1;

import java.util.Random;

/**
 * Class which implements Object Card Card SuperScoopUp using a Visitor pattern to visit the player.
 * @author Adèle Bourgeix
 */

public class SuperScoopUp extends AObjectCard {

    /**
     * Constructor for the SuperScoopUp
     * @param aName name for the card
     * @param aDescription description for the card
     */
    public SuperScoopUp(String aName, String aDescription){
        super(aName, aDescription);
    }


    @Override
    public void beingPlayedBy(Player player){
        Random random = new Random();
        int rand= random.nextInt(2);
        if(rand==1){
            IPokemon pokemon= player.getBank().get(1);
            IObjectCard object=pokemon.getObjectCardAssociated();
            if(object!=null){
                pokemon.associateObjectCard(null);
                player.takeCard(this);
            }
            player.getBank().remove(1);
            player.takeCard(pokemon);
        }
        player.eliminate(this);
    }
}
