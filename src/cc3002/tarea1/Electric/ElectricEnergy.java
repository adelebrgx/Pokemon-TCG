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
    public ElectricEnergy(){this.name="Electric";}

    @Override
    public String type(){
        return "Electric";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        if (inAction.getBank().size() == 0) {
            System.out.println("There is no Pokemon to apply this energy to");
        } else {
            inAction.getSelectedPokemon().addElectricEnergy(this);
        }
    }
}
