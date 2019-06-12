package cc3002.tarea1;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller class which controls the state of the game
 * @author Adèle Bourgeix
 */
public class Controller {

    private Player first;
    private Player second;
    private Player isPlaying;
    private IStateCard stateCard;



    /**
     * Method which sets the game, creating two players, setting them in their first state, giving the turn to the first player
     */
    public void initGame(){
        first=new Player("First");
        second=new Player("Second");
        stateCard=null;


        first.assignController(this);
        second.assignController(this);

        second.setPlaying(false);
        second.setEndingTurn(false);
        first.setPlayingEnergy(false);
        first.setUsingAbility(false);

        first.setEndingTurn(false);
        first.setPlaying(true);
        first.setPlayingEnergy(false);
        first.setUsingAbility(false);

        isPlaying=first;



    }

    /**
     * State of the controller is updated each time the state of a player changes. If the player's done playing it switches turn
     * @param p Player playing updating the game
     */
    public void update(Player p){
       if(p.getEndingTurn()){
           if(isPlaying.equals(first)){
               first.setPlaying(false);
               first.setPlayingEnergy(false);
               first.setUsingAbility(false);
               first.setEndingTurn(false);
               SwitchTurns(second);
           }
           else{
               second.setPlaying(false);
               second.setUsingAbility(false);
               second.setPlayingEnergy(false);
               second.setEndingTurn(false);
               SwitchTurns(first);
           }
       }
    }

    /**
     * Getter to the game's first player
     * @return first player
     */
    public Player getFirst(){
        return first;
    }

    /**
     * Getter to the game's second player
     * @return second player
     *.
     */
    public Player getSecond(){
        return second;
    }

    /**
     * Method to assign a state card to the game. Only one state card can be in game
     * @param card
     */
    public void setStateCard(IStateCard card){
        stateCard=card;
    }

    /**
     * Getter to the game's state card
     * @return game's state card
     */
    public IStateCard getStateCard(){
        return this.stateCard;
    }


    /**
     * Allows to give hand to the player
     * @param player which is now allowed to play
     */
    public void SwitchTurns(Player player){
        isPlaying=player;
        player.setPlaying(true);
    }


    /**
     * Returns which player is playing
     * @return the playing trainer
     */
    public Player getPlaying(){
        return this.isPlaying;
    }

    /**
     * Displays message everytime a player tries to play when he's not allowed to
     */
    public void error(){
        System.out.println("This is not the player's turn");
    }
}
