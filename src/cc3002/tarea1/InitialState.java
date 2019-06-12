package cc3002.tarea1;

import cc3002.tarea1.Fire.FireEnergy;
/**
 * Class which represent initial state. State in which the player can draw a card
 * @author Adèle Bourgeix
 */
public class InitialState extends PlayerState {

    @Override
    public void drawCard(Player player){
        FirstState first= new FirstState();
        first.setPlayer(player);
        this.changeState(first);
    }

    @Override
    public boolean isInInitialState(){
        return true;
    }
}
