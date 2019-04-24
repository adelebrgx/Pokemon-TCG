package cc3002.tarea1.Fire;

import cc3002.tarea1.AEnergy;

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
}
