package cc3002.tarea1.Electric;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 * Class which extends the notion of energy card to electric energies
 * @author Adèle Bourgeix
 */
public class ElectricEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Electric"
     */
    public ElectricEnergy(){super("Electric");}

    @Override
    public String type(){
        return "Electric";
    }

    @Override
    public void beingPlayedBy(Player inAction) {

        if(canbeUsed(inAction)){
            inAction.getbenefiecient().addElectricEnergy(this);
            inAction.getHand().remove(this);
            inAction.setPlayingEnergy(true);
        }
    }
}
