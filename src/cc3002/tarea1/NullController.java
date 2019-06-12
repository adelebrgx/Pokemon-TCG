package cc3002.tarea1;

/**
 * A null controller for when a controller hasn't been assigned, to test other player's functionnalities. (cc Null Object pattern)
 */
public class NullController extends Controller {


    @Override
    public void update(Player p){}

    @Override
    public void SwitchTurns(Player player){}

    @Override
    public void error(){}
}
