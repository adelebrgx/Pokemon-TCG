package cc3002.tarea1;

import java.util.Random;

/**
 * Class which implements Support Card Professor Cozmos Discovery using a Visitor pattern to visit the player.
 * @author Adèle Bourgeix
 */
public class ProfessorCozmosDiscovery extends ASupportCard {

    /**
     * Constructor for Pr Cozmos Discovery card
     * @param aName the name of the card
     * @param aDescription the description of the card
     */
    public ProfessorCozmosDiscovery(String aName, String aDescription){super(aName, aDescription);}

    @Override
    public void beingPlayedBy(Player player){
        if (!player.getSupportPlayed()){
            Random random = new Random();
            int rand= random.nextInt(2);
            if(rand==1){
                player.getCard(3);
            }
            else{
                player.getCard(2);
            }
            super.beingPlayedBy(player);
        }

    }
}
