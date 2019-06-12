package cc3002.tarea1;

/**
 * Class which represent the state in which is a player during his/her turn. Implements the State Pattern.
 * @author  Adèle Bourgeix
 */
public class PlayerState {
    private Player player;

    /**
     * When a player draws a card
     * @param player drawing the card
     */
    public void drawCard(Player player){}

    /**
     * When the player ends his/her actions
     * @param player ending actions
     */
    public void endActions(Player player){}

    /**
     * When player performs attack
     * @param player performing attacks
     */
    public void attack(Player player){}

    /**
     * When player ends his/her turn
     * @param player ending turn
     */
    public void endTurn(Player player){ }

    /**
     * Set a player to the state
     * @param player being assigned
     */
    public void setPlayer(Player player) {
        this.player = player;
    }


    /**
     * When an action is performed, the player's state changes
     * @param state new state
     */
    public void changeState(PlayerState state) {
        state.player.setState(state);
    }

    /**
     * If is in initial state
     * @return true
     */
    public boolean isInInitialState(){
        return false;
    }

    /**
     * If is in first state
     * @return true
     */
    public boolean isInFirstState(){
        return false;
    }

    /**
     * if is in second state
     * @return true
     */
    public boolean isInSecondState(){
        return false;
    }

}
