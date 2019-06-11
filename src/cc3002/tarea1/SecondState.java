package cc3002.tarea1;

public class SecondState extends PlayerState {
    public void attack(Player player){
        InitialState initial= new InitialState();
        initial.setPlayer(player);
        player.setEndingTurn(true);
        this.changeState(initial);

    }

    public void endTurn(Player player){
        InitialState initial= new InitialState();
        initial.setPlayer(player);
        player.setEndingTurn(true);
        this.changeState(initial);
    }

    public boolean isInSecondState(){
        return true;
    }
}
