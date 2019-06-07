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
    public FightingEnergy(){this.name="Fighting";}

    @Override
    public String type(){
        return "Fighting";
    }

    @Override
    public void beingPlayedBy(Player inAction) {
        if (inAction.getBank().size() == 0) {
            System.out.println("There is no Pokemon to apply this energy to");
        } else {
            inAction.getSelectedPokemon().addFightingEnergy(this);
        }
    }
}
