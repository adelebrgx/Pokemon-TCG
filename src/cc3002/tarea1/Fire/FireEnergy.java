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
    public FireEnergy() {
        super("Fire");
    }

    @Override
    public String type() {
        return "Fire";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        if (canbeUsed(inAction)) {
            inAction.getbenefiecient().addFireEnergy(this);
            inAction.getHand().remove(this);
            inAction.setPlayingEnergy(true);
        }
    }
}
