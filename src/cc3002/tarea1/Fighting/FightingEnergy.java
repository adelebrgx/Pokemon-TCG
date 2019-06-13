package cc3002.tarea1.Fighting;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 * Class which extends the notion of energy card to fighting energies
 * @author Adèle Bourgeix
 */
public class FightingEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Fighting"
     */
    public FightingEnergy(){super("Fighting");}

    @Override
    public String type(){
        return "Fighting";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        if (canbeUsed(inAction)) {
            inAction.getbenefiecient().addFightingEnergy(this);
            inAction.getHand().remove(this);
            inAction.setPlayingEnergy(true);
        }
    }

}
