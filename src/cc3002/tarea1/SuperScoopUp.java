package cc3002.tarea1;

import java.util.Random;

public class SuperScoopUp extends AObjectCard {

    public SuperScoopUp(String aName, String aDescription){
        super(aName, aDescription);
    }


    @Override
    public void beingPlayedBy(Player player){
        Random random = new Random();
        int rand= random.nextInt(2);
        if(rand==1){
            IPokemon pokemon= player.getBank().get(1);
            player.getBank().remove(1);
            player.takeCard(pokemon);
        }
        super.beingPlayedBy(player);
    }
}
