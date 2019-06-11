package cc3002.tarea1;

import cc3002.tarea1.Fire.FireEnergy;

public class InitialState extends PlayerState {
    public void drawCard(Player player){
        FirstState first= new FirstState();
        first.setPlayer(player);
        this.changeState(first);
    }

    public boolean isInInitialState(){
        return true;
    }
}
