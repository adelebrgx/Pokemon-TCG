package cc3002.tarea1.Water;

import cc3002.tarea1.AEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Player;

import java.util.HashMap;

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

    public void beingPlayedBy(Player inAction) {
        if (inAction.getBank().size() == 0) {
            System.out.println("There is no Pokemon to apply this energy to");
        } else {
            inAction.getSelectedPokemon().addWaterEnergy(this);
        }
    }


}
