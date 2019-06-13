package cc3002.tarea1.Plant;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.Player;

/**
 *Class which extends the notion of energy card to plant energies
 * @author Adèle Bourgeix
 */
public class PlantEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Plant"
     */
    public PlantEnergy() {
        super("Plant");
    }

    @Override
    public String type() {
        return "Plant";
    }


    @Override
    public void beingPlayedBy(Player inAction) {

        if(canbeUsed(inAction)){
            inAction.getbenefiecient().addPlantEnergy(this);
            inAction.getHand().remove(this);
            inAction.setPlayingEnergy(true);
        }

    }

}
