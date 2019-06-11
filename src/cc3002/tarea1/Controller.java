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
    private PlayerState state;


    /**
     * Method which sets the game, creating two players, setting the them in their first state, giving the turn to the first player
     */
    public void initGame(){
        first=new Player("First");
        second=new Player("Second");

        first.assignController(this);
        second.assignController(this);

        second.setPlaying(false);
        second.setEndingTurn(false);

        first.setEndingTurn(false);
        first.setPlaying(true);

        isPlaying=first;



    }

    public void update(Player p){
       if(p.getEndingTurn()){
           if(isPlaying.equals(first)){
               first.setPlaying(false);
               SwitchTurns(second);
           }
           else{
               second.setPlaying(false);
               SwitchTurns(first);
           }
       }
    }

    public Player getFirst(){
        return first;
    }

    public Player getSecond(){
        return second;
    }

    public void SwitchTurns(Player player){
        isPlaying=player;
        player.setPlaying(true);
    }

    public Player getPlaying(){
        return this.isPlaying;
    }

    public void error(){
        System.out.println("This is not the player's turn");
    }
}
