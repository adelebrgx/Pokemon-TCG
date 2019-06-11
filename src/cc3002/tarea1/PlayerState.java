package cc3002.tarea1;

public class PlayerState {
    private Player player;

    public void drawCard(Player player){}

    public void endActions(Player player){}

    public void attack(Player player){}

    public void endTurn(Player player){ }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void changeState(PlayerState state) {
        state.player.setState(state);
    }

    public boolean isInInitialState(){
        return false;
    }
    public boolean isInFirstState(){
        return false;
    }
    public boolean isInSecondState(){
        return false;
    }

}
