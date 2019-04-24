package cc3002.tarea1.Water;

import cc3002.tarea1.AEnergy;

/**
 * Class which extends the notion of energy card to water energies
 * @author Adèle Bourgeix
 */
public class WaterEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Water"
     */
    public WaterEnergy(){super("Water");}

    @Override
    public String type(){
        return "Water";
    }


}
