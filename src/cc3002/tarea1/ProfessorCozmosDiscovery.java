package cc3002.tarea1;

import java.util.Random;

public class ProfessorCozmosDiscovery extends ASupportCard {

    public ProfessorCozmosDiscovery(String aName, String aDescription){super(aName, aDescription);}

    public void beingPlayedBy(Player player){
        Random random = new Random();
        int rand= random.nextInt(2);
        if(rand==1){
                player.getCard(3);
        }
        else{
                player.getCard(2);
        }
    }
}
