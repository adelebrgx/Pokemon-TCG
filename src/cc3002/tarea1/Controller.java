package cc3002.tarea1;

/**
 * Controller class which controls the state of the game
 * @author Adèle Bourgeix
 */
public class Controller {

    private Player first;
    private Player second;
    private int phaseFirst;
    private int phaseSecond;
    private int turn;

    /**
     * Method which sets the game, creating two players, setting the them in their first state, giving the turn to the first player
     */
    public void initGame(){
        first=new Player("First");
        second=new Player("second");
        phaseFirst=0;
        phaseSecond=0;
        turn=0;
    }
}
