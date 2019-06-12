package cc3002.tarea1;


/**
 * Class which represent State 2. State in which is a player when he's ended his/her actions. He can attack or end his turn.
 * @author Adèle Bourgeix
 */
public class SecondState extends PlayerState {

    @Override
    public void attack(Player player){
        InitialState initial= new InitialState();
        initial.setPlayer(player);
        player.setEndingTurn(true);
        this.changeState(initial);

    }

    @Override
    public void endTurn(Player player){
        InitialState initial= new InitialState();
        initial.setPlayer(player);
        player.setEndingTurn(true);
        this.changeState(initial);
    }

    @Override
    public boolean isInSecondState(){
        return true;
    }
}
