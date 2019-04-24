package cc3002.tarea1.Psychic;

import cc3002.tarea1.AEnergy;

/**
 * Class which extends the notion of energy card to psychic energies
 * @author Adèle Bourgeix
 */
public class PsychicEnergy extends AEnergy {

    /**
     * Creates an energy of type water given it the name "Psychic"
     */
    public PsychicEnergy(){super("Psychic");}

    @Override
    public String type(){
        return "Psychic";
    }
}
