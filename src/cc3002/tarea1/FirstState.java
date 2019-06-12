package cc3002.tarea1;

/**
 * Class which represent State 1. State in which is a player when he's drawn the card. In this State,
 * he can play cards, visualize his POkemons and the ones of his opponent, see his cards, play cards (only one energy)
 * and activate one ability.
 * @author Adèle Bourgeix
 */


public class FirstState extends PlayerState {

   @Override
    public void endActions(Player player){
        SecondState second= new SecondState();
        second.setPlayer(player);
        this.changeState(second);

    }

    @Override
    public boolean isInFirstState(){
        return true;
    }
}
