package cc3002.tarea1.Fire;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 * Class which extends the notion of energy card to fire energies
 * @author Adèle Bourgeix
 */
public class FireEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Fire"
     */
    public FireEnergy(){super("Fire");}

    @Override
    public String type(){
        return "Fire";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        int index=inAction.submitIndex(this);
        if (inAction.getBank().size() == 0 || index==-1) {
            System.out.println("There is no Pokemon to apply this energy to");
        } else {
            if(inAction.getPlayingEnergy()){
                System.out.println("One energy has already been used");
            }
            else {
                inAction.getBank().get(index).addFireEnergy(this);
                inAction.setPlayingEnergy(true);
            }
        }
    }
}
