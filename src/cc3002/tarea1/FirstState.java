package cc3002.tarea1;

public class FirstState extends PlayerState {
    public void endActions(Player player){
        SecondState second= new SecondState();
        second.setPlayer(player);
        this.changeState(second);

    }

    public boolean isInFirstState(){
        return true;
    }
}
